package chapter3.practice;

import static net.mindview.util.Print.print;

/**
 * @author lh
 */
public class RightShiftTest_p03_11 {
    public static void main(String[] args) {
        int h = 0x10000000;
        print(Integer.toBinaryString(h));
        for (int i = 0; i < 29; i++) {
            h>>>=1;
            print(Integer.toBinaryString(h));
        }
    }
}
