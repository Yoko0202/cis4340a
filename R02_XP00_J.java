package main;

import java.io.File;

public class R02_XP00_J {

    public static void main(String[] args) {
        deleteFile();
    }

    public static void deleteFile() {
        File someFile = new File("someFileName.txt");
        // Do something with someFile
        if (!someFile.delete()) {
            // Handle failure to delete the file
            System.err.println("Failed to delete the file.");
        }
    }
}
