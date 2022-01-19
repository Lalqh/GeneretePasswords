package files;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 *
 * Developed by @CompactDevs
 */

public class Files {

    protected FileOutputStream writeFile;
    protected FileInputStream readFile;

    public Files(FileOutputStream writeFile) {
        this.writeFile = writeFile;
    }

    public Files(FileInputStream readFile) {
        this.readFile = readFile;
    }
}
