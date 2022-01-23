import files.ReadFile;
import files.WriteFile;
import files.arguments.ObtainingData;
import functions.GeneratePassoword;

import java.io.*;
import java.util.Scanner;

/**
 *
 * Developed by @CompactDevs
 */

public class Main {

    private static void createDir(){
        File directorry = new File("resources");
        if (directorry.mkdir()) {
            System.out.println();
        }
    }

    public static void main(String[] args) throws InterruptedException {
      createDir();
        System.out.println("Bienvenido a la app generador de contraseñas.\n" +
                "Desarrollado por @ComapactDevs");
        System.out.println();
      menu();
    }

    public static void menu() throws InterruptedException {
        int option;
        Scanner input = new Scanner(System.in);
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
                        break;
                    case 2:
                        showAllPaswords();
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
            System.err.println("Error, debes de ingresar un numero, intenta nuevamente");
            System.out.println();
            Thread.sleep(100);
            menu();
        }
    }

    private static void generateAndSavePassword(){
        Scanner input = new Scanner(System.in);
        String namePassword, password;
        try{
            FileOutputStream writeBin = new FileOutputStream("resources/password.bin", true);
            System.out.println("Generando una contraseña...");
            GeneratePassoword generatePassoword = new GeneratePassoword();
            password = generatePassoword.generatePassword();
            System.out.println("La contraseña generada es: "+password);
            System.out.print("Ahora ingrese un nombre como identificador para la contraseña: ");
            namePassword = input.nextLine();
            WriteFile writeFile = new WriteFile(writeBin, new ObtainingData(namePassword, password));
            writeFile.writeInFile();
            System.out.println("Datos guardardos correctamente.");
        }catch (IOException exception){
            System.err.println("Ocurrio un error al almacenar la contrasñea");
        }
    }

    private static void showAllPaswords(){
        try {
            FileInputStream readBin = new FileInputStream("resources/password.bin");
            ReadFile readFile = new ReadFile(readBin);
            readFile.showPassowrds();
        } catch (IOException exception){
            System.err.println("Ocurrio un error al leer los datos");
        }
    }
}