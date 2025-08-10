package chapter4;

import static net.mindview.util.Print.print;

/**
 * @author lh
 */
public class IfElse {
    static int result = 0;

    static void test(int testval, int target) {
        //<editor-fold desc="can be replace:
        // result = Integer.compare(testval, target);
        // ">
        if (testval > target) {
            result = +1;
        } else if (testval < target) {
            result = -1;
        } else
        //Match
        {
            result = 0;
        }
        //</editor-fold>
    }

    public static void main(String[] args) {
        test(10, 5);
        print(result);
        test(5, 10);
        print(result);
        test(5, 5);
        print(result);
    }
}
