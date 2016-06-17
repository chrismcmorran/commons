package utilities.io.files;

import utilities.crypto.CRC32;
import utilities.crypto.MD5;

import java.io.*;
import java.math.BigInteger;
import java.net.URI;
import java.util.Scanner;

public class File extends java.io.File {

	/**
	 * Creates a new <code>File</code> instance by converting the given
	 * pathname string into an abstract pathname.  If the given string is
	 * the empty string, then the result is the empty abstract pathname.
	 *
	 * @param pathname A pathname string
	 * @throws NullPointerException If the <code>pathname</code> argument is <code>null</code>
	 */
	public File(String pathname) {
		super ( pathname );
	}

	/**
	 * Creates a new <code>File</code> instance from a parent pathname string
	 * and a child pathname string.
	 * <p>
	 * <p> If <code>parent</code> is <code>null</code> then the new
	 * <code>File</code> instance is created as if by invoking the
	 * single-argument <code>File</code> constructor on the given
	 * <code>child</code> pathname string.
	 * <p>
	 * <p> Otherwise the <code>parent</code> pathname string is taken to denote
	 * a directory, and the <code>child</code> pathname string is taken to
	 * denote either a directory or a file.  If the <code>child</code> pathname
	 * string is absolute then it is converted into a relative pathname in a
	 * system-dependent way.  If <code>parent</code> is the empty string then
	 * the new <code>File</code> instance is created by converting
	 * <code>child</code> into an abstract pathname and resolving the result
	 * against a system-dependent default directory.  Otherwise each pathname
	 * string is converted into an abstract pathname and the child abstract
	 * pathname is resolved against the parent.
	 *
	 * @param parent The parent pathname string
	 * @param child  The child pathname string
	 * @throws NullPointerException If <code>child</code> is <code>null</code>
	 */
	public File(String parent, String child) {
		super ( parent, child );
	}

	/**
	 * Creates a new <code>File</code> instance from a parent abstract
	 * pathname and a child pathname string.
	 * <p>
	 * <p> If <code>parent</code> is <code>null</code> then the new
	 * <code>File</code> instance is created as if by invoking the
	 * single-argument <code>File</code> constructor on the given
	 * <code>child</code> pathname string.
	 * <p>
	 * <p> Otherwise the <code>parent</code> abstract pathname is taken to
	 * denote a directory, and the <code>child</code> pathname string is taken
	 * to denote either a directory or a file.  If the <code>child</code>
	 * pathname string is absolute then it is converted into a relative
	 * pathname in a system-dependent way.  If <code>parent</code> is the empty
	 * abstract pathname then the new <code>File</code> instance is created by
	 * converting <code>child</code> into an abstract pathname and resolving
	 * the result against a system-dependent default directory.  Otherwise each
	 * pathname string is converted into an abstract pathname and the child
	 * abstract pathname is resolved against the parent.
	 *
	 * @param parent The parent abstract pathname
	 * @param child  The child pathname string
	 * @throws NullPointerException If <code>child</code> is <code>null</code>
	 */
	public File(java.io.File parent, String child) {
		super ( parent, child );
	}

	/**
	 * Creates a new <tt>File</tt> instance by converting the given
	 * <tt>file:</tt> URI into an abstract pathname.
	 * <p>
	 * <p> The exact form of a <tt>file:</tt> URI is system-dependent, hence
	 * the transformation performed by this constructor is also
	 * system-dependent.
	 * <p>
	 * <p> For a given abstract pathname <i>f</i> it is guaranteed that
	 * <p>
	 * <blockquote><tt>
	 * new File(</tt><i>&nbsp;f</i><tt>.{@link #toURI() toURI}()).equals(</tt><i>&nbsp;f</i><tt>.{@link #getAbsoluteFile() getAbsoluteFile}())
	 * </tt></blockquote>
	 * <p>
	 * so long as the original abstract pathname, the URI, and the new abstract
	 * pathname are all created in (possibly different invocations of) the same
	 * Java virtual machine.  This relationship typically does not hold,
	 * however, when a <tt>file:</tt> URI that is created in a virtual machine
	 * on one operating system is converted into an abstract pathname in a
	 * virtual machine on a different operating system.
	 *
	 * @param uri An absolute, hierarchical URI with a scheme equal to
	 *            <tt>"file"</tt>, a non-empty path component, and undefined
	 *            authority, query, and fragment components
	 * @throws NullPointerException     If <tt>uri</tt> is <tt>null</tt>
	 * @throws IllegalArgumentException If the preconditions on the parameter do not hold
	 * @see #toURI()
	 * @see URI
	 * @since 1.4
	 */
	public File(URI uri) {
		super ( uri );
	}

	/**
	 * Gets the raw bytes of this file.
	 * @return	A byte[].
     */
	public byte[] bytes() {
		try {
			InputStream stream = new FileInputStream(this);
			byte[] bytes = new byte[(int) this.length()];
			stream.read(bytes);
			return bytes;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Converts this file into a String containing it's contents.
	 * @return	A String.
     */
	public String contents() {
		StringBuilder buffer = new StringBuilder((int) length());
		try {
			Scanner scanner = new Scanner(this);
			while (scanner.hasNextLine()) buffer.append(scanner.nextLine());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return buffer.toString();
	}

	/**
	 * Gets an InputStream on this file.
	 * @return	An InputStream.
     */
	public InputStream toInputStream() {
		try {
			return new FileInputStream(this);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Returns the MD5 Hash Sum of the contents of this file.
	 * @return	A String.
     */
	public String getMD5() {
		return MD5.hash(contents());
	}

	public String getCRC32() {
		return new CRC32(contents()).hash();
	}

	public String getHEX() {
        return String.format("%x", new BigInteger(1, bytes()));
    }


    /**
     * Appends the specified String to this file.
     * @param contents  The String to append.
     * @return          This file.
     */
    public File append(String contents) {
        try {
            OutputStream stream = new FileOutputStream(this, true);
            stream.write(contents.getBytes());
            stream.flush();
            stream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    /**
     * Determines the number of words in the specified file.
     * Words are determined by the " " String.
     * @return  An int.
     */
    public int wordCount() {
        return contents().split(" ").length;
    }

    /**
     * Determines the number of newlines in ths pecified file.
     * @return  An int.
     */
    public int lineCount() {
        return contents().split("\n").length;
    }

}
