public class Test {
    public Test() {
        System.out.println("Hello, World!");
        int[] mapping = {0,2,3,1};
        LetterMap someMap = new LetterMap(4, mapping);
        System.out.println(someMap.getVal(someMap.getInverse(1))==1);
        System.out.println(someMap.toString());
        someMap.increaseOffset();
        someMap.increaseOffset();
        someMap.increaseOffset();
        System.out.println(someMap.toString());
    }
}
