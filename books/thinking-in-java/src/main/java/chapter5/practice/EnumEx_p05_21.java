package chapter5.practice;

/**
 * Create an enum of the least-valuable
 * @author liu.hua
 */
public class EnumEx_p05_21 {
    public enum Bills {
       ONE,FIVE,TEN,TWENTY,FIFTY,HUNDRED
    }

    public static void main(String[] args) {
        for (Bills b : Bills.values()) {
            System.out.println(b + ", ordinal " + b.ordinal());
        }
    }
}
