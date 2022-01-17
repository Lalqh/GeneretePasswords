package files;

import files.arguments.ObtainingData;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * Developed by @CompactDevs
 */

public class ReadFile extends Files {

    public ReadFile(FileInputStream readFile) {
        super(readFile);
    }

    public String searchPassword(String passwordName) {
        return passwordName;
    }

    public void showPassowrds() {
        ObtainingData arguments;
        int i=0;
        try {
            ObjectInputStream read = new ObjectInputStream(readFile);
            while (true){
                arguments = (ObtainingData) read.readObject();
                System.out.println("Mostrando la contraseña numero: "+(i+1));
                System.out.println("Nombre de la contraseña: "+arguments.getPasswordName());
                System.out.println("Contraseña: "+arguments.getPassword());
            }
        } catch (EOFException eofException){
            return;
        } catch (IOException ioException) {
            System.err.println("Error "+ioException);
        } catch (ClassNotFoundException classNotFoundException) {
            System.err.println("error "+classNotFoundException);
        }
    }
}
