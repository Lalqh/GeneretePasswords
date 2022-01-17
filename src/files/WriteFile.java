package files;

import files.arguments.ObtainingData;
import files.functionsbin.FunctionBin;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

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
            FunctionBin writer = new FunctionBin(writeFile);
            writer.writeObject(data);
            writer.close();
        }catch (IOException ioException) {
            System.err.println("Error, " +ioException);
        }
    }
}
