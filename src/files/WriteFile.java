package files;

import files.arguments.ObtainingData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile extends Files {

    private ObtainingData data;

    public WriteFile(File file, ObtainingData data) {
        super(file);
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
            FileWriter writer = new FileWriter(file, true);
            writer.write(data.getPasswordName()+"%"+data.getPassword()+"\r\n");
            writer.close();
        }catch (IOException ioException){
            System.err.println("exception = " + ioException);
        }
    }
}
