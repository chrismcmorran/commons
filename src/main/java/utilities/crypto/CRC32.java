package utilities.crypto;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.zip.Checksum;

public class CRC32 extends HashSum {
    private java.util.zip.CRC32 _crc;

    public CRC32(String toHash) {
        update(toHash.getBytes());
    }

    public String hash() {
        return String.valueOf(this.getValue());
    }

    /**
     * Updates the CRC-32 checksum with the specified byte (the low
     * eight bits of the argument b).
     *
     * @param b the byte to update the checksum with
     */
    public void update(int b) {
        _crc.update(b);
    }

    /**
     * Resets CRC-32 to initial value.
     */
    public void reset() {
        _crc.reset();
    }

    /**
     * Updates the CRC-32 checksum with the specified array of bytes.
     *
     * @throws ArrayIndexOutOfBoundsException
     *          if {@code off} is negative, or {@code len} is negative,
     *          or {@code off+len} is greater than the length of the
     *          array {@code b}
     * @param b
     * @param off
     * @param len
     */
    public void update(byte[] b, int off, int len) {
        _crc.update(b, off, len);
    }

    /**
     * Updates the CRC-32 checksum with the specified array of bytes.
     *
     * @param b the array of bytes to update the checksum with
     */
    public void update(byte[] b) {
        _crc.update(b);
    }

    /**
     * Updates the CRC-32 checksum with the specified byte buffer.
     * @param buffer    The Byte Buffer to use.
     * @return          This CRC32.
     */
    public CRC32 update(ByteBuffer buffer) {
        _crc.update(buffer.array());
        return this;
    }

    /**
     * Returns CRC-32 value.
     */
    public long getValue() {
        return _crc.getValue();
    }
}
