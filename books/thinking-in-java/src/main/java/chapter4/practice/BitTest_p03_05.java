package chapter4.practice;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

/**
 * @author lh
 */
public class BitTest_p03_05 {
    static void binaryPrint(int q) {
        if (q ==0) {
            System.out.println(0);
        } else {
            int nlz = Integer.numberOfLeadingZeros(q);
            q <<= nlz;
            for(int p = 0; p < 32 - nlz ; p++) {
                int n = (Integer.numberOfLeadingZeros(q) == 0) ? 1 : 0;
                System.out.print(n);
                q <<= 1;
            }
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int i = 1 + 4 + 16 + 64;
        int j = 2+ 8 + 32 + 128;
        int k = 0x100;
        int m = 0;
        print("Using Integer.toBinaryString():");
        print("i= " + Integer.toBinaryString(i));
        print("j= " + Integer.toBinaryString(j));
        print("k= " + Integer.toBinaryString(k));
        print("m= " + Integer.toBinaryString(m));
        print("i & j = " + (i & j) + " = " + Integer.toBinaryString(i & j));
        print("i | j = " + (i | j) + " = " + Integer.toBinaryString(i | j));
        print("i ^ j = " + (i ^ j) + " = " + Integer.toBinaryString(i ^ j));
        print("~i = " + Integer.toBinaryString(~i));
        print("~j = " + Integer.toBinaryString(~j));
        print("Using binaryPrint():");
        printnb("i = " + i + " =");
        binaryPrint(i);
        printnb("j = " + j + " =");
        binaryPrint(j);
        printnb("k = " + k + " =");
        binaryPrint(k);
        printnb("m = " + m + " =");
        binaryPrint(m);
        printnb("i & j = " + (i & j) + " = ");
        binaryPrint(i & j);
        printnb("i | j = " + (i | j) + " = ");
        binaryPrint(i | j);
        printnb("i ^ j = " + (i ^ j) + " = ");
        binaryPrint(i ^ j);
        printnb("~i = ");
        binaryPrint(~i);
        printnb("~j = ");
        binaryPrint(~j);
    }
}
