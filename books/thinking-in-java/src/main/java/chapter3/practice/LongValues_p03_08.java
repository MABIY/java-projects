package chapter3.practice;

import static net.mindview.util.Print.print;

/**
 * @author lh
 */
public class LongValues_p03_08 {
    public static void main(String[] args) {
        //hexadecimal
        long n1 = 0xffff;
        //octal
        long n2 = 077777;
        print("long n1 in hex = " + Long.toBinaryString(n1));
        print("long n2 in hex = " + Long.toBinaryString(n2));
    }
}
