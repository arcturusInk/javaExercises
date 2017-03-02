package assignmentone;

import java.io.*;
import java.util.*;

/**
*Solve the Caesar Cipher problem.
* As the user if they'd like to encrypt or decrypt the file.
* Ask for the string key.  Ask for the input and output filename.
* The encryption is solved by adding the numeric values of the key
* to the input .  This may mean that the key needs to be repeated
* many times.  The numeric values of the key can be calculated by
* determining the offset of the letter into the alphabet (a=0, b=1, c=2, etc).
* Please note, that the key will only contain letters, the input
* may contain other characters, but the key will only contain letters
* and it is NOT case sensitive.  Upper case will always convert to upper case.
* Lower case will always convert to lower case.
* For example, "Hello world!" + "Password" ="Weddk nrglv!"
* @author Swati Barua
*/
public class AssignmentOne {
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    String garbledText; String unGarbledText;


    public static String encrypt (String inputString, String key, String garbledText){
        char garbledLetter = '';
        for (int i = 0; i < inputString.length(); i++){
            int keyPosition = ((ALPHABET.indexOf(key.charAt(i)))+1);//key: getting the position (array number) of each letter in the key
            char currentLetter = inputString.charAt(i);//get the current letter from the inputString
            int inputPosition = ALPHABET.indexOf(currentLetter);//inputString: getting the position (array number) of the letter
            int finalPosition = (inputPosition + keyPosition) % 26; //position the cipher letter will be in

            if (Character.isUpperCase(currentLetter) == true){//if the current letter is capital, then make the garbled letter capital
                garbledLetter = Character.toUpperCase(ALPHABET.charAt(finalPosition));//getting the garbled letter, settin it to capital
            }else if (Character.isLowerCase(currentLetter) == true){
                garbledLetter = Character.toLowerCase(ALPHABET.charAt(finalPosition));
            }
            garbledText += garbledLetter;
        }
        return garbledText;
    }

        public static String decrypt (String inputString, String key, String unGarbledText){
            char unGarbledLetter = '';
            for (int i = 0; i < inputString.length(); i++){
                int keyPosition = (ALPHABET.indexOf(key.charAt(i)));
                char currentLetter = inputString.charAt(i);
                int inputPosition = ALPHABET.indexOf(currentLetter);//get the single letter, get its position/index number
                int finalPosition = (((inputPosition - keyPosition) % 26)+1);

                if(Character.isUpperCase(currentLetter) == true){
                    unGarbledLetter = Character.toUpperCase(ALPHABET.charAt(finalPosition));
                }else if(Character.isLowerCase(currentLetter) == true){
                    unGarbledLetter = Character.toLowerCase(ALPHABET.charAt(finalPosition));
                }

                unGarbledText += unGarbledLetter;
            }
            return unGarbledText;
        }

    public static void main(String[] args) throws IOException{
        //ask if user wants to encrypt or decrypt
        Scanner input = new Scanner (System.in);
        System.out.println("Would you like to encrypt or decrypt the file? Answer with either 'encrypt' or 'decrypt': ");
        String enOrDe = input.next(); // get the string value
        //ask for key
        Scanner input2 = new Scanner (System.in);
        System.out.println("Please enter the string key: ");
        String key = input2.next();
        //ask for input file
        Scanner input3 = new Scanner (System.in);
        System.out.println("Please enter the name of the input file: ");
        String inputFile = input3.next();
        //ask for output file
        Scanner input4 = new Scanner (System.in);
        System.out.println("Please enter the name of the output file: ");
        String outputFile = input4.next();
        //read the input file
        String inputString = "";
        Scanner inFile = new Scanner(new File(inputFile));
        while (inFile.hasNextLine()) {
               inputString = inputString + inFile.nextLine();
        }
        //output to the file, after encrypting or decrypting
        PrintStream outFile = new PrintStream(new FileOutputStream(outputFile));
        if(enOrDe == "encrypt"){
            String garbledText = encrypt(inputString,key,garbledText);
            outFile.print(garbledText);
        }else{
            String unGarbledText = decrypt(inputString,key,unGarbledText);
            outFile.print(unGarbledText);
        }

        inFile.close();
        outFile.close();
    }

}
