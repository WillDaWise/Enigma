public class Cog extends LetterCode {

    private LetterCode next;
    private boolean[] notches;
    private int notchOffset;

    public Cog(LetterCode next) {
        this(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
             14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25}, next);
    }
    public Cog(int[] arr, LetterCode next) {
        this(arr, next, new boolean[arr.length]);
        notches[0] = true;
    }

    public Cog(int[] arr, LetterCode next, boolean[] notches) {
        super(arr);
        this.next = next;
        this.notches = notches.clone();
    }

    boolean rotate(boolean notchEngaged) {
        boolean nextRotated = next.rotate(notches[notchOffset]);
        if (notchEngaged || nextRotated) {
            notchOffset = (notchOffset + 1) % notches.length;
            map.increaseOffset();
            return true;
        }
        return false;
    }

    int convert(int in) {
        int nextResult = next.convert(this.map.getVal(in));
        return this.map.getInverse(nextResult);
    }
    
}
