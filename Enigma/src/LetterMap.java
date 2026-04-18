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
        String output = "Forward mapping: [";
        for (int i = 0; i < len; i++) {
            output+=forwardsMapping[(i+offset)%len];
            if (i < len - 1) {
                output+= ", ";
            }
        }
        output += "]\n";
        int[] reverse = new int[len];
        for (int i = 0; i < len; i++) {
            reverse[(forwardsMapping[(i + offset) % len])] =  i; 
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
        offset = (offset + amount) % len;
        return offset;
    }

    public int getVal(int index) {
        return forwardsMapping[(index + offset) % len];
    }
    
    public int getInverse(int val) {
        for (int i = 0; i < len; i++) {
            if (forwardsMapping[i] == val) {
                return (i - offset + len) % len;
                // possibly (i - offset) % len
            }
        }
        return -1;
    }
}
