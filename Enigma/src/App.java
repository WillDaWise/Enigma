import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        //Test t = new Test();
        
        System.out.println(toValue('Z'));
        //String input = "YRUHQSLDPXNGOKMIEBFZCWVJAT";
        //System.out.println(input);
        //System.out.println(Arrays.toString(toValues(input)));
        Cog enigmaOne = createDefault();
        System.out.println(encryptDecrypt("a", enigmaOne));
        
        
        /*Reflector reflector = new Reflector();
        Cog iCog = new Cog(reflector);
        System.out.println(iCog.rotate(true));
        System.out.println(iCog.convert(0));
        System.out.println(iCog.rotate(true));
        System.out.println(iCog.convert(0));
        System.out.println(iCog.rotate(true));
        System.out.println(iCog.convert(0));
        System.out.println(iCog.rotate(true));
        System.out.println(iCog.convert(0));
        System.out.println(iCog.rotate(true));
        System.out.println(iCog.convert(0));
        */
    }

    public static String encryptDecrypt(String input, Cog machine) {
        int[] values = toValues(input);
        int[] outputValues = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            machine.rotate();
            outputValues[i] = machine.convert(values[i]);
        }
        return toCharacters(outputValues);
    }

    public static Cog createDefault() {
        Reflector r = new Reflector();
        // note, these notchvalues are a guess - MUST FIGURE OUT HOW THESE WORK!!!
        Cog iiiCog = createCog("BDFHJLCPRTXVZNYEIWGAKMUSQO", r, 0, toValue('F'), "III");
        Cog iiCog = createCog("AJDKSIRUXBLHWTMCQGZNPYFVOE", iiiCog, 0, toValue('F'), "II");
        Cog iCog = createCog("EKMFLGDQVZNTOWYHXUSPAIBRCJ", iiCog, 25, toValue('F'), "I");
        return iCog;
    }

    public static Cog createCog(String s, LetterCode next, int startPos, int notchPos, String name) {
        return new Cog(toValues(s), next, startPos, notchPos, name);
    }
static char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 
                'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 
                'V', 'W', 'X', 'Y', 'Z'};
    public static char toCharacter(int value) {
        return toCharacter(value, alphabet);
    }

    public static char toCharacter(int value, char[] alphabet) {
        return alphabet[value];
    }

    public static String toCharacters(int[] values) {
        String output = "";
        for (int i = 0; i < values.length; i++) {
            output += alphabet[values[i]];
        }
        return output;
    }
    
    public static int[] toValues(String letters) {
        letters = letters.replaceAll("[^a-zA-Z]", "");
        letters = letters.toUpperCase();
        int len = letters.length();
        int[] values = new int[len];
        for (int i = 0; i < len; i++) {
            values[i] = toValue(letters.charAt(i));
        }
        return values;
    }

    public static int toValue(char character) {
        return character - 65;
    }

    public static int toValue(char character, char[] alphabet) {
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == character) {
                return i;
            }
        }
        return -1;
    }
}
