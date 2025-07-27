package chapter3;

import static net.mindview.util.Print.print;

/**
 * @author lh
 */
public class Precedence {
    public static void main(String[] args) {
        int x = 1, y = 2, z = 3;
        int a = x + y - 2 / 2 + z;
        int b = x + (y - 2) / (2 + z);
        print("a = " + a + " b = " + b);
    }
}
