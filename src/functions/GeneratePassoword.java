package functions;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 *
 * Developed by @CompactDevs.
 */

/*
* Spanish.
* Esta clase es la mas importante de este programa,
* ya que es la que genera las contraseñas aleatoriamente.
*-------------------------------------------------------
* English.
*This class is the most important of this program,
since it is the one that generates the passwords randomly.
*/

public class GeneratePassoword {

    // This method generates a random String and returns that string, but with 8 characters.
    private String genereteRadomString() {
        SecureRandom secureRandom = new SecureRandom();
        String characters = new BigInteger(130, secureRandom).toString(32);
        return characters.substring(0, 8);
    }

    /* This method returns a string, with uppercase letters and characters to add to the password
    (the previous method cannot generate uppercase letters nor the characters found in this string).
     */
    private String generateCapsAndChar() {
        return "ABCDEFGHIJKLMNOPQRSTUVWXYZ-/.^&*_!@=+>)";
    }

    /* This method generates a random number to know how many characters of the string generated with
    genereteRadomString are going to be replaced.
     */
    private int generateChangeNumber() {
        return (int) (Math.random()*4+1);
    }

    /* This method generates a random number, which we use to obtain a character from the method
    generateCapsAndChar
     */
    private int generatePossForCaps() {
        return (int) (Math.random()*39);
    }

    /* This method generates a random number which is the position of an array, to replace a part
    of the string returned by genereteRadomString with one from the generateCapsAndChar method.
     */
    private int generatePossCharacters() {
        return (int) (Math.random()*7);
    }

    /*This entry does the logic of generating a string and replacing it with something else,
    to generate a password as random as possible.
     */
    public String generatePassword() {
        String password;
        char[] prePasword;
        char capsLock;

        prePasword = genereteRadomString().toCharArray();

        for (int i = 0; i <generateChangeNumber(); i++) {
            capsLock = generateCapsAndChar().charAt(generatePossForCaps());
            prePasword[generatePossCharacters()]=capsLock;
        }

        return password = String.valueOf(prePasword);
    }
}
