package chapter4.practice;

/**
 * A Fibonacci sequence is the sequence of numbers 1,1,3,5,8,13,21,34,
 * and so on, where each number (from the third on) is the sum of hte previous
 * two. Create a method that takes an integer as argument and displays that
 * many fibonacci numbers starting from the beginning, e.g,if you run java
 * Fibonacci 5 (where Fibonacci is the name of the class) the output will be
 * 1,1,2,3,5.
 * @author lh
 */
public class Fibonacci {

    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        for (int i = 0; i < k; i++) {
            System.out.print(fib(i)+" ");
        }

    }

    public static int fib(int x){
        if(x < 2){
            return 1;
        }
        return fib(x - 1) + fib(x - 2);
    }
}
