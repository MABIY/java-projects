package chapter5.practice;

/**
 * Create a class containing an unitialized String  reference.
 * Demonstrate  that // this reference is initialized by java to null.
 *
 * @author liu.hua
 */
class Tester {
    String s;
}
public class ConstructorTest_p05_01 {
    public static void main(String[] args) {
        Tester t = new Tester();
        System.out.println(t.s);
    }

    private  class Test {

    }
    protected class Test1 {

    }
}
