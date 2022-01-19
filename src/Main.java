import files.Files;
import files.ReadFile;
import files.WriteFile;
import files.arguments.ObtainingData;
import functions.GeneratePassoword;

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
    private static Scanner input = new Scanner(System.in);

    private static void createDir(){
        File directorry = new File("resources");
        if (directorry.mkdir()){
            initializeFiles();
        }else {
            initializeFiles();
        }
    }

    private static void initializeFiles(){
        try {
            writeBin = new FileOutputStream("resources/password.bin", true);
            readBin = new FileInputStream("resources/password.bin");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        createDir();
        System.out.println("Bienvenido a la app generador de contraseñas.\n" +
                "Desarrollado por @ComapactDevs");
        System.out.println();
        menu();
        System.out.println();
    }

    public static void menu(){
        int option;
        try {
            do {
                System.out.println("\t::Menu::");
                System.out.println("1. Generar y guardar contraseña.");
                System.out.println("2. Mostrar todas las contraseñas guardadas.");
                System.out.println("3. Buscar una contraseña.");
                System.out.print("4. Salir.");
                System.out.print("\nIngrese su opcion: ");
                option = input.nextInt();
                System.out.println();

                switch (option){
                    case 1:
                        generateAndSavePassword();
                        System.out.println();
                        break;
                    case 2:
                        showAllPaswords();
                        System.out.println();
                        break;
                    case 3:
                        break;

                    case 4:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("No existe esta opcion, intente nuevamente");
                }
            }while (option!=4);
        }catch (Exception e){
            System.err.println("Error, debes de ingresar un numero...");
            System.out.println();
            menu();
        }
    }

    private static void generateAndSavePassword(){
        input.nextLine();
        String namePassword, password;
        System.out.println("Generando una contraseña...");
        GeneratePassoword generatePassoword = new GeneratePassoword();
        password = generatePassoword.generatePassword();
        System.out.println("La contraseña generada es: "+password);
        System.out.print("Ahora ingrese un nombre como identificador para la contraseña: ");
        namePassword = input.nextLine();
        WriteFile writeFile = new WriteFile(writeBin, new ObtainingData(namePassword, password));
        writeFile.writeInFile();
        System.out.println("Datos guardardos correctamente.");
    }

    private static void showAllPaswords(){
        ReadFile readFile = new ReadFile(readBin);
        readFile.showPassowrds();
    }
}