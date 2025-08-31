package chapter5;

import java.util.Arrays;

/**
 * @author liu.hua
 */
public class ArrayInit {
    public static void main(String[] args) {
        Integer[] a = {
                new Integer(1),
                new Integer(2),
                3, //Autoboxing
        };

        Integer[] b = new Integer[]{
                new Integer(1),
                new Integer(2),
                //Autoboxing
                3,
        };
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));

    }
}
