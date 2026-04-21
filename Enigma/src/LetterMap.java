import java.util.Arrays;

public class LetterMap {
    private int len;
    private int[] forwardsMapping;
    private int offset;
    // private int[] inverseMapping;
    public LetterMap(int len, int[] mapping) {
        this(len, mapping, 0);
        /*this.inverseMapping = new int[len];
        for (int i = 0; i < len; i++) {
            inverseMapping[forwardsMapping[i]] = i; 
        }
        System.out.println(Arrays.toString(forwardsMapping));
        System.out.println(Arrays.toString(inverseMapping));*/
    }
    public LetterMap(int len, int[] mapping, int offset) {
        this.len = len;
        this.forwardsMapping = mapping.clone();
        this.offset = offset % len;
    }
    public String toString() {
        String output = "Note, currently wrong, add offset to vals. Array Stored: " + Arrays.toString(this.forwardsMapping);
        output += "\nOffset: " + offset;
        output += "\nForward mapping: [";
        for (int i = 0; i < len; i++) {
            output+=getVal(i);
            if (i < len - 1) {
                output+= ", ";
            }
        }
        output += "]\n";
        int[] reverse = new int[len];
        for (int i = 0; i < len; i++) {
            reverse[getVal(i)] =  i; 
        }
        output += "Reverse mapping: [";
        for (int i = 0; i < len; i++) {
            output+=reverse[i];
            if (i < len - 1) {
                output+= ", ";
            }
        }
        output += "]\n";
        return output;
    }
    public int increaseOffset() {
        return this.increaseOffset(1);
    }
    private int increaseOffset(int amount) {
        this.offset = modLen(offset + amount);
        return offset;
    }

    private int modLen(int val) {
        return (val + len) % len;
    }

    public int getVal(int index) {
        return modLen(forwardsMapping[(index + offset) % len] - offset);
    }
    
    public int getInverse(int val) {
        // System.out.println(this.toString());
        for (int i = 0; i < len; i++) {
            if (getVal(i) == val) {
                return i;
            }
        }
        
        
        
        /* 
        for (int i = 0; i < len; i++) {
            if (forwardsMapping[i] == val) {
                return (i + offset) % len;
                // possibly (i - offset) % len
            }
        }*/
        return -1;
    }
}
