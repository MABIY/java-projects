package chapter5.practice;

/**
 * Create a class with a constructor that takes a String argument. During
 * constriction,print the argument. Create and array of object references to this
 * class ,but don't acutally create objects to assign into the array into the array. When you run
 * the program, notice whether the initialization messages from the construcotr are printed
 *
 * @author liu.hua
 */
public class InitTest_p05_18 {
    public static void main(String[] args) {
        InitTest[] it = new InitTest[10];
        for (int i = 0; i < it.length; i++) {
            it[i] = new InitTest(Integer.toString(i));
        }
    }

}
