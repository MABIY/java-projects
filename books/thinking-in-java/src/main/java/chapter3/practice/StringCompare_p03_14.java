package chapter3.practice;

import static net.mindview.util.Print.print;

/**
 * Write a method that task two string arguments uses all the boolean
 * comparisons to compare to the two strings and print the results. For the == and
 * !=, also perform the equals() test. In main(), test your method with some
 * different String objects.
 * @author lh
 */
public class StringCompare_p03_14 {
    static void f(boolean b) {
        if (b == true) {
            print(true);
        }else {
            print(false);
        }
    }

    static void stringTest(String s, String t) {
        f(s == t);
        f(s.equals(t));
        f(t.equals(s));
        f(s != t);
    }

    public static void main(String[] args) {
        String s = "one", t = "two";
        stringTest(s, t);
    }
}
