package chapter2.practice;

// object/Documentation4.java
// TIJ4 Chapter Object, Exercise 14, page 90
// Add an HTML list of items to the documentation in the previous exercise.
import java.util.*;

// object/Documentation4.java

/**
 * You can even insert a list:
 * <ol>
 *     <li> Item one</li>
 *     <li> Item two</li>
 *     <li> Item three</li>
 * </ol>
             */
public class Documentation4_p02_14 {
    /** Let's try a public field list
     * <ol>
     *     <li> one </li>
     *     <li> two </li>
     *     <li> three </li>
     * </ol>
     */

    public int i =2;


    /**
     * a private field list (-private to see)
     * <ol>
     *
     *     <li> one </li>
     *     <li> two </li>
     *     <li> three </li>
     * </ol>
     */
    private int j =3;

    /**
     * Another list can be inserted here to help explain the
     * following method call
     * <ol>
     *     <li> One </li>
     *     <li> Two </li>
     *     <li> Three </li>
     *     <li> One </li>
     * </ol>
     * but may be formatter differently in Method Summary
     */
    public static void main(String[] args) {
        /**
         * Let's try another test list here
         * <ol>
         *     <li> One</li>
         *     <li> Two</li>
         *     <li> Three</li>
         * </ol>
         */
        Date d = new Date();
        System.out.println("d = " + d);

    }
}
