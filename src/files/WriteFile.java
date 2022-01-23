package files;

import files.arguments.ObtainingData;
import files.functionsbin.Binary;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * Developed by @CompactDevs
 */

public class WriteFile extends Files{

    private final ObtainingData arguments;

    public WriteFile(FileOutputStream wiriteFile, ObtainingData arguments) {
        super(wiriteFile);
        this.arguments = arguments;
    }

    public void writeInFile(){
        try {
            Binary writer = new Binary(writeFile);
            writer.writeObject(arguments);
            writer.close();
        }catch (IOException ioException) {
            System.err.println("Error, " +ioException);
        }
    }
}
