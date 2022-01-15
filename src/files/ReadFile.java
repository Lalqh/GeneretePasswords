package files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile extends Files{

    public ReadFile(File file) {
        super(file);
    }

    public String searchPassword(String passwordName){
        return passwordName;
    }

    public void showPassowrds(){
        try {
            Scanner read = new Scanner(file);
            while (read.hasNextLine()){
                System.out.println(read.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
