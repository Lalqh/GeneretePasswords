package files;

import files.arguments.ObtainingData;
import files.functionsbin.Binary;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * Developed by @CompactDevs
 */

public class WriteFile extends Files {

    private ObtainingData arguments;

    public WriteFile(FileOutputStream writeFile, ObtainingData arguments) {
        super(writeFile);
        this.arguments = arguments;
    }

    public ObtainingData getData() {
        return arguments;
    }

    public void setData(ObtainingData data) {
        this.arguments = data;
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
