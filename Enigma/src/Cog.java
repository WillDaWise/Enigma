public class Cog extends LetterCode {

    private LetterCode next;
    private boolean[] notches;
    private int notchOffset;
    private String name; 

    public Cog(LetterCode next) {
        this(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
             14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25}, next, 0, 0, "default");
    }
    public Cog(int[] rotorWiring, LetterCode next, int startPos, int notchPos, String name) {
        this(rotorWiring, next, startPos, notchPos, new boolean[rotorWiring.length]);
        this.name = name;
    }

    public Cog(int[] rotorWiring, LetterCode next, int startPos, int notchPos, boolean[] notches) {
        super(rotorWiring, startPos);
        this.notchOffset = startPos;
        this.next = next;
        this.notches = notches.clone();
        this.notches[notchPos] = true;
    }

    public String toString() {
        return "Cog: " + name + ", lettermap: " + this.map.toString();
    }

    boolean rotate() {
        return this.rotate(true);
    }

    boolean rotate(boolean notchEngaged) {
        boolean nextRotated = next.rotate(notches[notchOffset]);
        if (notchEngaged || nextRotated) {
            notchOffset = (notchOffset - 1 + notches.length) % notches.length;
            map.increaseOffset();
            System.out.println("notch offset increased at cog " + name + ", now: " + (notchOffset));
            System.out.println();
            return true;
        }
        return false;
    }

    int convert(int in) {
        System.out.println(this.toString());
        System.out.println("At cog " + name);
        System.out.println("number in: " + in);
        System.out.println("number out: " + this.map.getVal(in));

        int nextResult = next.convert(this.map.getVal(in));
        System.out.println("returning through Cog " + name);
        System.out.println("num in: " + nextResult);
        System.out.println("numout: " + this.map.getInverse(nextResult));
        //System.out.println(this.map.toString());
        return this.map.getInverse(nextResult);
    }
    
}
