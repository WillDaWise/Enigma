public abstract class LetterCode {
    LetterMap map;
    abstract boolean rotate(boolean increaseNotchOffset);
    abstract int convert(int in);
    protected LetterCode (int[] arr, int offset) {
        this.map = new LetterMap(arr.length, arr, offset);
    }
}
