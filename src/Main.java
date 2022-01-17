import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 *
 * Developed by @CompactDevs
 */

public class Main {

    public static void main(String[] args) {
        FileOutputStream writeBin=null;
        FileInputStream readBin= null;
        try {
            writeBin = new FileOutputStream("resources/password.bin", true);
            readBin = new FileInputStream("resources/password.bin");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}