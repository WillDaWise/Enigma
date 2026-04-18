public class Reflector extends LetterCode {
    
    public Reflector(int[] arr) {
        super(arr);
    }

    public Reflector() {
        this(new int[] {1, 0, 3, 2, 5, 4, 7, 6, 9, 8, 11, 
            10, 13, 12, 15, 14, 17, 16, 19, 18, 21, 20, 23, 22, 25, 24});
    }

    


    public boolean rotate() {
        return false;
    }
    public int convert(int in) {
        return map.getVal(in);
    }
}
