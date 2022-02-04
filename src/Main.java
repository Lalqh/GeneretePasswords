import files.ReadFile;
import files.WriteFile;
import files.arguments.ObtainingData;
import functions.GeneratePassoword;

import java.io.*;
import java.util.Scanner;

/**
 *
 * Developed by @CompactDevs
 */

public class Main {

    private static void createDir() {
        File directorry = new File("resources");
        if (directorry.mkdir()) {
            System.out.println();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        createDir();
    }
}