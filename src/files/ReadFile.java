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

    private ObjectInputStream read;
    private ObtainingData arguments;

    public ReadFile(FileInputStream readFile) {
        super(readFile);
    }

    public ObtainingData searchPassword(String passwordName) {
        boolean found = false;
        try {
            read = new ObjectInputStream(readFile);
            while (!found) {
                arguments = (ObtainingData) read.readObject();
                if (arguments.getPasswordName().equals(passwordName)) {
                    found = true;
                }
            }
        }catch (IOException | ClassNotFoundException exception){
            arguments = null;
        }
        return arguments;
    }

    public void showPassowrds() {
        int i=0;
        try {
            read = new ObjectInputStream(readFile);
            while (true){
                arguments = (ObtainingData) read.readObject();
                System.out.println("Mostrando la contraseña numero: "+i);
                System.out.println("Nombre de la contraseña: "+arguments.getPasswordName());
                System.out.println("Contraseña: "+arguments.getPassword());
                i++;
                System.out.println();
            }
        }catch (EOFException eofException){
            return;
        }catch (IOException ioException) {
            System.err.println("Error "+ioException);
        }catch (ClassNotFoundException classNotFoundException) {
            System.err.println("error "+classNotFoundException);
        }
    }
}
