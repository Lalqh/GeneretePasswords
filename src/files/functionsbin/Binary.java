package files.functionsbin;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class Binary extends ObjectOutputStream {

    public Binary(OutputStream out) throws IOException {
        super(out);
    }

    protected Binary() throws IOException, SecurityException {
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        File bin = new File("resources/password.bin");

        if (bin.length()==0){
            super.writeStreamHeader();
        }else {
            reset();
        }
    }
}