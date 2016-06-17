package utilities.io.streams;

import utilities.io.files.File;

public class Printer {

    /**
     * The same as calling System.out.println()
     * @param o The Object to print.
     */
    public static void println(Object o) {
        System.out.println(o);
    }

    /**
     * Prints the specified String to the specified File.
     * @param file      The File to write to.
     * @param string    The String to write.
     */
    public static void println(File file, String string) {
        file.append(string);
    }

}
