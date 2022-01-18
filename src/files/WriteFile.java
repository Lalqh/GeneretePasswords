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

    private ObtainingData data;

    public WriteFile(FileOutputStream writeFile, ObtainingData data) {
        super(writeFile);
        this.data = data;
    }

    public ObtainingData getData() {
        return data;
    }

    public void setData(ObtainingData data) {
        this.data = data;
    }

    public void writeFiles(){
        try {
            Binary writer = new Binary(writeFile);
            writer.writeObject(data);
            writer.close();
        }catch (IOException ioException) {
            System.err.println("Error, " +ioException);
        }
    }
}
