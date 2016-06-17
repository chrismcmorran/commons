package utilities.crypto;

import java.nio.ByteBuffer;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;

public class MD5 extends HashSum {
    private MessageDigest _md5;

    public MD5(String toHash) {
        try {
            _md5 = MessageDigest.getInstance(toHash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }


    public static String hash(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (byte anArray : array) {
                sb.append(Integer.toHexString((anArray & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            return null;
        }
    }

    /**
     * Returns the provider of this message digest object.
     *
     * @return the provider of this message digest object
     */
    public Provider getProvider() {
        return _md5.getProvider();
    }

    /**
     * Returns the length of the digest in bytes, or 0 if this operation is
     * not supported by the provider and the implementation is not cloneable.
     *
     * @return the digest length in bytes, or 0 if this operation is not
     * supported by the provider and the implementation is not cloneable.
     *
     * @since 1.2
     */
    public int getDigestLength() {
        return _md5.getDigestLength();
    }

    /**
     * Updates the digest using the specified byte.
     *
     * @param input the byte with which to update the digest.
     */
    public void update(byte input) {
        _md5.update(input);
    }

    /**
     * Updates the digest using the specified array of bytes.
     *
     * @param input the array of bytes.
     */
    public void update(byte[] input) {
        _md5.update(input);
    }

    /**
     * Returns a string that identifies the algorithm, independent of
     * implementation details. The name should be a standard
     * Java Security name (such as "SHA", "MD5", and so on).
     * See the MessageDigest section in the <a href=
     * "{@docRoot}/../technotes/guides/security/StandardNames.html#MessageDigest">
     * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
     * for information about standard algorithm names.
     *
     * @return the name of the algorithm
     */
    public String getAlgorithm() {
        return _md5.getAlgorithm();
    }

    /**
     * Compares two digests for equality. Does a simple byte compare.
     *
     * @param digesta one of the digests to compare.
     *
     * @param digestb the other digest to compare.
     *
     * @return true if the digests are equal, false otherwise.
     */
    public static boolean isEqual(byte[] digesta, byte[] digestb) {
        return MessageDigest.isEqual(digesta, digestb);
    }

    /**
     * Performs a final update on the digest using the specified array
     * of bytes, then completes the digest computation. That is, this
     * method first calls {@link #update(byte[]) update(input)},
     * passing the <i>input</i> array to the {@code update} method,
     * then calls {@link #digest() digest()}.
     *
     * @param input the input to be updated before the digest is
     * completed.
     *
     * @return the array of bytes for the resulting hash value.
     */
    public byte[] digest(byte[] input) {
        return _md5.digest(input);
    }

    /**
     * Update the digest using the specified ByteBuffer. The digest is
     * updated using the {@code input.remaining()} bytes starting
     * at {@code input.position()}.
     * Upon return, the buffer's position will be equal to its limit;
     * its limit will not have changed.
     *
     * @param input the ByteBuffer
     * @since 1.5
     */
    public void update(ByteBuffer input) {
        _md5.update(input);
    }

    /**
     * Updates the digest using the specified array of bytes, starting
     * at the specified offset.
     *  @param input the array of bytes.
     *
     * @param offset the offset to start from in the array of bytes.
     *@param len the number of bytes to use, starting at
     * {@code offset}.
     */
    public void update(byte[] input, int offset, int len) {
        _md5.update(input, offset, len);
    }

    /**
     * Completes the hash computation by performing final operations
     * such as padding. The digest is reset after this call is made.
     *
     * @param buf output buffer for the computed digest
     *
     * @param offset offset into the output buffer to begin storing the digest
     *
     * @param len number of bytes within buf allotted for the digest
     *
     * @return the number of bytes placed into {@code buf}
     *
     * @exception DigestException if an error occurs.
     */
    public int digest(byte[] buf, int offset, int len) throws DigestException {
        return _md5.digest(buf, offset, len);
    }

    /**
     * Resets the digest for further use.
     */
    public void reset() {
        _md5.reset();
    }

    /**
     * Completes the hash computation by performing final operations
     * such as padding. The digest is reset after this call is made.
     *
     * @return the array of bytes for the resulting hash value.
     */
    public byte[] digest() {
        return _md5.digest();
    }

    public String hash() {
        return null;
    }
}
