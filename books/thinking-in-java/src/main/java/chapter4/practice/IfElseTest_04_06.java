package chapter4.practice;

import static net.mindview.util.Print.print;

/**
 * @author lh
 */
public class IfElseTest_04_06 {
    // correct way to write
//    static int test(int testVal, int begin, int end) {
//        if(end < begin) {
//            print("end cannot be < begin");
//        }
//        if (testVal > (begin - 1) && (testVal < (end + 1))) {
//            return +1;
//        } else {
//            return -1;
//        }
//    }
    static int test(int testVal, int begin, int end) {
        if(end < begin) {
            print("end cannot be < begin");
        }
        if (testVal > (begin - 1) && (testVal < (end + 1))) {
            return +1;
        }

        if((testVal < begin) || (testVal > end))
            return -1;

        print("exceptinal case");
        return 13;
    }

    public static void main(String[] args) {
        print(test(10, 5, 4));
        print(test(5, 4, 10));
        print(test(5, 5, 6));
        print(test(10, 5, 7));
        print(test(5, 5, 5));

    }
}
