package utilities.networking.UDP;

import utilities.Logger;

import java.io.IOException;
import java.net.*;

public class UDPSocket extends DatagramSocket {
    /**
     * The number of attempts allowed to send or receive a packet.
     */
    protected static int MAX_REATTEMPTS = 3;
    private Logger logger = new Logger(false, false);

    /**
     * Constructs a datagram socket and binds it to any available port
     * on the local host machine.  The socket will be bound to the
     * {@link InetAddress#isAnyLocalAddress wildcard} address,
     * an IP address chosen by the kernel.
     * <p>
     * <p>If there is a security manager,
     * its {@code checkListen} method is first called
     * with 0 as its argument to ensure the operation is allowed.
     * This could result in a SecurityException.
     *
     * @throws SocketException   if the socket could not be opened,
     *                           or the socket could not bind to the specified local port.
     * @throws SecurityException if a security manager exists and its
     *                           {@code checkListen} method doesn't allow the operation.
     * @see SecurityManager#checkListen
     */
    public UDPSocket() throws SocketException {
    }

    /**
     * Creates an unbound datagram socket with the specified
     * DatagramSocketImpl.
     *
     * @param impl an instance of a <B>DatagramSocketImpl</B>
     *             the subclass wishes to use on the DatagramSocket.
     * @since 1.4
     */
    protected UDPSocket(DatagramSocketImpl impl) {
        super(impl);
    }

    /**
     * Creates a datagram socket, bound to the specified local
     * socket address.
     * <p>
     * If, if the address is {@code null}, creates an unbound socket.
     * <p>
     * <p>If there is a security manager,
     * its {@code checkListen} method is first called
     * with the port from the socket address
     * as its argument to ensure the operation is allowed.
     * This could result in a SecurityException.
     *
     * @param bindaddr local socket address to bind, or {@code null}
     *                 for an unbound socket.
     * @throws SocketException   if the socket could not be opened,
     *                           or the socket could not bind to the specified local port.
     * @throws SecurityException if a security manager exists and its
     *                           {@code checkListen} method doesn't allow the operation.
     * @see SecurityManager#checkListen
     * @since 1.4
     */
    public UDPSocket(SocketAddress bindaddr) throws SocketException {
        super(bindaddr);
    }

    /**
     * Constructs a datagram socket and binds it to the specified port
     * on the local host machine.  The socket will be bound to the
     * {@link InetAddress#isAnyLocalAddress wildcard} address,
     * an IP address chosen by the kernel.
     * <p>
     * <p>If there is a security manager,
     * its {@code checkListen} method is first called
     * with the {@code port} argument
     * as its argument to ensure the operation is allowed.
     * This could result in a SecurityException.
     *
     * @param port port to use.
     * @throws SocketException   if the socket could not be opened,
     *                           or the socket could not bind to the specified local port.
     * @throws SecurityException if a security manager exists and its
     *                           {@code checkListen} method doesn't allow the operation.
     * @see SecurityManager#checkListen
     */
    public UDPSocket(int port) throws SocketException {
        super(port);
    }

    /**
     * Creates a datagram socket, bound to the specified local
     * address.  The local port must be between 0 and 65535 inclusive.
     * If the IP address is 0.0.0.0, the socket will be bound to the
     * {@link InetAddress#isAnyLocalAddress wildcard} address,
     * an IP address chosen by the kernel.
     * <p>
     * <p>If there is a security manager,
     * its {@code checkListen} method is first called
     * with the {@code port} argument
     * as its argument to ensure the operation is allowed.
     * This could result in a SecurityException.
     *
     * @param port  local port to use
     * @param laddr local address to bind
     * @throws SocketException   if the socket could not be opened,
     *                           or the socket could not bind to the specified local port.
     * @throws SecurityException if a security manager exists and its
     *                           {@code checkListen} method doesn't allow the operation.
     * @see SecurityManager#checkListen
     * @since JDK1.1
     */
    public UDPSocket(int port, InetAddress laddr) throws SocketException {
        super(port, laddr);
    }

    public boolean isOpen() {
        return !isClosed();
    }

    public UDPSocket send(UDPPacket packet) {
        int attempt = 0;
        while (attempt < MAX_REATTEMPTS) {
            if(_send(packet, attempt)) {
                logger.debug("Packet sent successfully.");
                break;
            } else {
                logger.debug("Packet failed to send!");
            }
        }
        return this;
    }

    public boolean _send(UDPPacket packet, int attempt) {
        logger.debug("Sending packet... Attempt: " + attempt);
        logger.debug(packet.toString());
        try {
            super.send(packet._packet);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

}
