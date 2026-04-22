public class Reflector extends LetterCode {
    
    public Reflector(int[] arr) {
        super(arr, 0);
    }

    // by default, uses UKW-B, the reflector used for the majority of WWII
    public Reflector() {
        this(new int[] {24, 17, 20, 7, 16, 18, 11, 3, 15, 23, 13, 6, 
                14, 10, 12, 8, 4, 1, 5, 25, 2, 22, 21, 9, 0, 19});
    }

    


    public boolean rotate(boolean increaseNotchOffset) {
        return false;
    }
    public int convert(int in) {
        System.out.println("At reflector, " + in + " in, " + this.map.getVal(in) + " out.");
        return map.getVal(in);
    }
}
