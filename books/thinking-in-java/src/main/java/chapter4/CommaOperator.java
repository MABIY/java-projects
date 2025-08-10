package chapter4;

/**
 * @author lh
 */
public class CommaOperator {
    public static void main(String[] args) {
        for(int i = 1, j = i *10; i < 5; i++,j = i*2) {
            System.out.println("i = " + i + " j = " + j);
        }
    }
    public void test() {
        int i = 1, c = i *2;
        System.out.println("i" + i + " c " + c);
    }
}
