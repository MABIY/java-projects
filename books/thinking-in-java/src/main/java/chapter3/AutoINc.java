package chapter3;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Demonstrates the ++ and -- operators.
 */
public class AutoINc {
    public static void main(String[] args) {
        int i = 1;
        print("i : " + i);
        print("++i : " + ++i); // pre-increment
        print("i++ : " + i++); // post-increment
        print("i : " + i);
        print("--i : " + --i); // pre-increment
        print("i-- : " + i--); // post-increment
        print("i : " + i);
    }
}
