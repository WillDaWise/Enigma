import java.util.Arrays;
import java.util.Scanner;

public class App {
    static char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 
                'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 
                'V', 'W', 'X', 'Y', 'Z'};
    // To create a new Enigma Machine, first create the reflector with 
    // "Reflector r = new Reflector();" with an optional argument in the constructor of an int[] containing the reflections, eg {1, 2, 0, 3}
    // Then, create cogs, starting from the left:
    // Cog c = createCog(stringMap, next, startPos, notchPos, name)
    // where stringMap is the list of characters in the order that you want them, eg "BCAD"
    // startPos is an int from 0 to 1 less than how many characters you want on your wheel, which determines in which position your Cog starts
    // notchpos is an int from 0 to 1 less than how many characters (eg 0 to 25), which determines the position the notch starts on the wheel 
    // name is a string that represents the Cog, eg "CogI"
    // next is either the reflector for the cog on the far left, or for each subsequent cog, is the cog to it's immediate left.
    public static void main(String[] args) throws Exception {
        //Test t = new Test();
        
        System.out.println(toValue('Z'));
        //String input = "YRUHQSLDPXNGOKMIEBFZCWVJAT";
        //System.out.println(input);
        //System.out.println(Arrays.toString(toValues(input)));
        Cog enigmaOne = createDoubleStep();
        String keyboard = "qwertyuiopasdfghjklzxcvbnm";
        System.out.println(encryptDecrypt("aaaaaaa", enigmaOne));
        
        
       
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

    public static Cog createDoubleStep() {
        Reflector r = new Reflector();
        System.out.println("Creating Enigma I with Cog I in the right, Cog II in the middle, and Cog III on the left, with Reflector B.");
        System.out.println("Notch Positions are such that a double step occurs for cog II on the third and fourth letter inputed");
        // note, these notchvalues are a guess - MUST FIGURE OUT HOW THESE WORK!!!
        Cog iiiCog = createCog("BDFHJLCPRTXVZNYEIWGAKMUSQO", r, 20, toValue('V'), "III");
        Cog iiCog = createCog("AJDKSIRUXBLHWTMCQGZNPYFVOE", iiiCog, 3, toValue('E'), "II");
        Cog iCog = createCog("EKMFLGDQVZNTOWYHXUSPAIBRCJ", iiCog, 14, toValue('Q'), "I");
        return iCog;
    }

    public static Cog createDefault() {
        Reflector r = new Reflector();
        System.out.println("Creating Enigma I with Cog I in the right, Cog II in the middle, and Cog III on the left, with Reflector B.");
        // note, these notchvalues are a guess - MUST FIGURE OUT HOW THESE WORK!!!
        Cog iiiCog = createCog("BDFHJLCPRTXVZNYEIWGAKMUSQO", r, 0, toValue('V'), "III");
        Cog iiCog = createCog("AJDKSIRUXBLHWTMCQGZNPYFVOE", iiiCog, 0, toValue('E'), "II");
        Cog iCog = createCog("EKMFLGDQVZNTOWYHXUSPAIBRCJ", iiCog, 0, toValue('Q'), "I");
        return iCog;
    }

    public static Cog createCog(String s, LetterCode next, int startPos, int notchPos, String name) {
        return new Cog(toValues(s), next, startPos, notchPos, name);
    }

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
