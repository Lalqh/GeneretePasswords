import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

/**
 *
 * Developed by @CompactDevs
 */

public class Main {

    private static FileOutputStream writeBin;
    private static FileInputStream readBin;

    public static void createDir(){
        File directorry = new File("resources");
        if (directorry.mkdir()){
            initializeFiles();
        }else {
            initializeFiles();
        }
    }

    public static void initializeFiles(){
        try {
            writeBin = new FileOutputStream("resources/password.bin", true);
            readBin = new FileInputStream("resources/password.bin");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void menu(){
        Scanner input = new Scanner(System.in);
        int option;
        try {
            do {
                System.out.println("\t::Menu::");
                System.out.println("1. Generar y guardar contraseña.");
                System.out.println("2. Mostrar todas las contraseñas guardadas.");
                System.out.println("3. Buscar una contraseña.");
                System.out.print("4. Salir.");
                System.out.print("Ingrese su opcion: ");
                option = input.nextInt();
                System.out.println();
            }while (option!=4);
        }catch (Exception e){
            System.err.println("Error, debes de ingresar un numero...");
            System.out.println();
            menu();
        }
    }

    public static void main(String[] args) {
        createDir();
        System.out.println("Bienvenido a la app generador de contraseñas.\n" +
                "Desarrollado por @ComapactDevs");
        System.out.println();
        menu();
    }
}