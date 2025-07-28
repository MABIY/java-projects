package chapter3;

import java.util.Random;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Using the bitwise operators
 */
public class BitManipulation {
    public static void main(String[] args) {
        Random rand = new Random(47);
        int i = rand.nextInt();
        int j = rand.nextInt();
        //todo
    }

    static void printBinaryInt(String s, int i) {
        print(s + ", int: " + i + ". binary:" + System.lineSeparator()
                + Integer.toBinaryString(i));
    }

    static void printBinaryLong(String s,long l) {
        print(s + ", int: " + l + ". binary:" + System.lineSeparator()
                + Long.toBinaryString(l));
    }
}
