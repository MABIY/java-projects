package chapter3.practice;

import static net.mindview.util.Print.print;

/**
 * @author lh
 */
public class BinaryTest_p03_10 {
    public static void main(String[] args) {
        int i = 1 + 4 + 16 + 64;
        int j = 2 + 8 + 32 + 128;
        print("i = " + Integer.toBinaryString(i));
        print("j = " + Integer.toBinaryString(j));
        print("i & j = " + Integer.toBinaryString(i & j));
        print("i | j = " + Integer.toBinaryString(i | j));
        print("i ^ j = " + Integer.toBinaryString(i ^ j));
        print("~i = " + Integer.toBinaryString(~i));
        print("~j = " + Integer.toBinaryString(~j));

        { //位操作对符号位也进行操作
            int c = -1;
            int d = 2;
            print("c = " + Integer.toBinaryString(c));
            print("d = " + Integer.toBinaryString(d));
            print("c ^ d = " + Integer.toBinaryString(c ^ d));
            System.out.println(c ^ d);
        }
        int test;
        int value;
        {
//            Java 中的移位行为（关键点）

//            int result = value << N;
//            int result = value >> N;
//            int result = value >>> N;
//            那么：
//
//            实际的移位位数为：N & 0x1F（也就是 N % 32）
//
//            Java 不允许移位超过 31 位（因为 int 是 32 位，最大索引是 31）

            test = 0B11;
            System.out.println("1 : " + test);
            value = test << 32;
            System.out.println("1<<32 : " + value);
            value = test << 31;
            System.out.println("1<< 31 : " + value);

            test = -2147483648;
            value = test >> 31;
            System.out.println("-2147483648 >> 31 :" + value);
            value = test >> 33;
            System.out.println("-2147483648 >> 33 :" + value);
            value = test >> 32;
            System.out.println("-2147483648 >> 32 :" + value);

            value = test >>> 31;
            System.out.println("-2147483648 >>> 31 :" + value);
            value = test >>> 33;
            System.out.println("-2147483648 >>> 33 :" + value);
            value = test >>> 32;
            System.out.println("-2147483648 >>> 32 :" + value);


        }
    }
}



