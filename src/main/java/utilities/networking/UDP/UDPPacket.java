package utilities.networking.UDP;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.SocketAddress;

public class UDPPacket {
    protected DatagramPacket _packet;

    /**
     * Returns the IP address of the machine to which this datagram is being
     * sent or from which the datagram was received.
     *
     * @return the IP address of the machine to which this datagram is being
     * sent or from which the datagram was received.
     * @see InetAddress
     * @see #setAddress(InetAddress)
     */
    public InetAddress getAddress() {
        return _packet.getAddress();
    }

    /**
     * Set the data buffer for this packet. With the offset of
     * this DatagramPacket set to 0, and the length set to
     * the length of {@code buf}.
     *
     * @param buf the buffer to set for this packet.
     * @throws NullPointerException if the argument is null.
     * @see #getLength
     * @see #getData
     * @since JDK1.1
     */
    public void setData(byte[] buf) {
        _packet.setData(buf);
    }

    /**
     * Sets the port number on the remote host to which this datagram
     * is being sent.
     *
     * @param iport the port number
     * @see #getPort()
     * @since JDK1.1
     */
    public void setPort(int iport) {
        _packet.setPort(iport);
    }

    /**
     * Set the data buffer for this packet. This sets the
     * data, length and offset of the packet.
     *
     * @param buf    the buffer to set for this packet
     * @param offset the offset into the data
     * @param length the length of the data
     *               and/or the length of the buffer used to receive data
     * @throws NullPointerException if the argument is null
     * @see #getData
     * @see #getOffset
     * @see #getLength
     * @since 1.2
     */
    public void setData(byte[] buf, int offset, int length) {
        _packet.setData(buf, offset, length);
    }

    /**
     * Sets the SocketAddress (usually IP address + port number) of the remote
     * host to which this datagram is being sent.
     *
     * @param address the {@code SocketAddress}
     * @throws IllegalArgumentException if address is null or is a
     *                                  SocketAddress subclass not supported by this socket
     * @see #getSocketAddress
     * @since 1.4
     */
    public void setSocketAddress(SocketAddress address) {
        _packet.setSocketAddress(address);
    }

    /**
     * Returns the data buffer. The data received or the data to be sent
     * starts from the {@code offset} in the buffer,
     * and runs for {@code length} long.
     *
     * @return the buffer used to receive or  send data
     * @see #setData(byte[], int, int)
     */
    public byte[] getData() {
        return _packet.getData();
    }

    /**
     * Returns the offset of the data to be sent or the offset of the
     * data received.
     *
     * @return the offset of the data to be sent or the offset of the
     * data received.
     * @since 1.2
     */
    public int getOffset() {
        return _packet.getOffset();
    }

    /**
     * Returns the length of the data to be sent or the length of the
     * data received.
     *
     * @return the length of the data to be sent or the length of the
     * data received.
     * @see #setLength(int)
     */
    public int getLength() {
        return _packet.getLength();
    }

    /**
     * Returns the port number on the remote host to which this datagram is
     * being sent or from which the datagram was received.
     *
     * @return the port number on the remote host to which this datagram is
     * being sent or from which the datagram was received.
     * @see #setPort(int)
     */
    public int getPort() {
        return _packet.getPort();
    }

    /**
     * Gets the SocketAddress (usually IP address + port number) of the remote
     * host that this packet is being sent to or is coming from.
     *
     * @return the {@code SocketAddress}
     * @see #setSocketAddress
     * @since 1.4
     */
    public SocketAddress getSocketAddress() {
        return _packet.getSocketAddress();
    }

    /**
     * Set the length for this packet. The length of the packet is
     * the number of bytes from the packet's data buffer that will be
     * sent, or the number of bytes of the packet's data buffer that
     * will be used for receiving data. The length must be lesser or
     * equal to the offset plus the length of the packet's buffer.
     *
     * @param length the length to set for this packet.
     * @throws IllegalArgumentException if the length is negative
     *                                  of if the length is greater than the packet's data buffer
     *                                  length.
     * @see #getLength
     * @see #setData
     * @since JDK1.1
     */
    public void setLength(int length) {
        _packet.setLength(length);
    }

    /**
     * Sets the IP address of the machine to which this datagram
     * is being sent.
     *
     * @param iaddr the {@code InetAddress}
     * @see #getAddress()
     * @since JDK1.1
     */
    public void setAddress(InetAddress iaddr) {
        _packet.setAddress(iaddr);
    }

    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("Address: " + this.getAddress().getHostAddress() + "\n").append("Port: " + this.getPort()).append("Size: " + this.getData().length + "\n").append("Offset: " + this.getOffset()).append("Data: " + new String(this.getData())).append("Socket: " + this.getSocketAddress());
        return buffer.toString();
    }
}
