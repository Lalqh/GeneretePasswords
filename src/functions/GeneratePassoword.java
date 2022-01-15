package functions;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 *
 * Developed by @CompactDevs
 */

public class GeneratePassoword {

    private String password;

    private String generateCapsLock(){
        return "ABCDEFGHIJKLMNOPQRSTUVWXYZ-/.^&*_!@=+>)";
    }

    private String genereteCharacters(){
        SecureRandom secureRandom = new SecureRandom();
        String characters = new BigInteger(130, secureRandom).toString(32);
        return characters = characters.substring(0, 8);
    }

    private int generatePossCharacters(){
        return (int) (Math.random()*7);
    }

    private int generateRadomNumer(){
        return (int) (Math.random()*39);
    }

    private int generatePosition(){
        return (int) (Math.random()*4+1);
    }

    public String generatePassword(){
        char[] prePasword;
        char capsLock;

        prePasword = genereteCharacters().toCharArray();

        for (int i = 0; i <generatePosition(); i++) {
            capsLock = generateCapsLock().charAt(generateRadomNumer());
            prePasword[generatePossCharacters()]=capsLock;
        }
        return password = String.valueOf(prePasword);
    }
}
