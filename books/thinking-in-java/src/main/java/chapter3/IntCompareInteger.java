package chapter3;

/**
 * @author lh
 */
public class IntCompareInteger {
    public static void main(String[] args) {
        int a =1291;
        Integer aIntegere = new Integer(1291);
        if (a == aIntegere) { // wrapperInt is unboxed to int
            System.out.println("int 1 == new Integer(1)");
        }else {
            System.out.println("int 1 != new Integer(1)");
        }
    }
}

