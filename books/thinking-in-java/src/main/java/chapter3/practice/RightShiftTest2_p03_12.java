package chapter3.practice;

import static net.mindview.util.Print.print;

/**
 * @author lh
 */
public class RightShiftTest2_p03_12 {
    public static void main(String[] args) {
        int h = -1;
        print(Integer.toBinaryString(h));
        h <<= 10;
        print(Integer.toBinaryString(h));
        for (int i = 0; i < 32; i++) {
            h>>>=1;
            print(Integer.toBinaryString(h));
        }
    }
}
