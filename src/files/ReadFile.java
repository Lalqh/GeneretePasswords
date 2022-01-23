package files;

import files.arguments.ObtainingData;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * Developed by @CompactDevs
 */

public class ReadFile extends Files{

    private ObjectInputStream read;
    private ObtainingData arguments;

    public ReadFile(FileInputStream readFile){
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
            arguments=null;
        }
        return arguments;
    }

    public void showPassowrds() {
        int i=1;
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
        } catch (IOException | ClassNotFoundException exception) {
            System.err.println();
        }
    }
}