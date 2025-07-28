package chapter3.practice;

import static net.mindview.util.Print.print;

/**
 * @author lh
 */
public class CharBinaryTest_p3_13 {
    public static void main(String[] args) {
        char c = 'a';
        print(Integer.toBinaryString(c));
        c = 'b';
        print(Integer.toBinaryString(c));
        c = 'c';
        print(Integer.toBinaryString(c));
        c = 'd';
        print(Integer.toBinaryString(c));
        c += 1;
        print(Integer.toBinaryString(c));
        c = 'A';
        print(Integer.toBinaryString(c));
        for (int i = 0; i < 26; i++) {
            c += 1;
            print(Integer.toBinaryString(c));
        }
    }
}
