import files.arguments.ObtainingData;

import files.Files;
import files.ReadFile;
import files.WriteFile;
import functions.GeneratePassoword;

import functions.ObtainingData;


import java.io.File;
import java.io.IOException;

/**
 *
 * Developed by @CompactDevs
 */

public class Main {

    public static void main(String[] args) {

        File file = new File("password.txt");
        try {
            if (file.createNewFile()){
                System.out.println();
            }
        }catch (IOException ioException){
            System.err.println("exception = " + ioException);
        }

        WriteFile writeFile = new WriteFile(file, new ObtainingData("Prubea", "wasd"));
        writeFile.writeFiles();

        ReadFile readFile = new ReadFile(file);

        readFile.showPassowrds();
    }
}