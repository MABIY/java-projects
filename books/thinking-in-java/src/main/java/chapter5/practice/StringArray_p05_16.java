package chapter5.practice;

/**
 * Create an array of String objects and assign a String to each element. Print
 * the arry by using a forloop.
 * @author liu.hua
 */
public class StringArray_p05_16 {
    public static void main(String[] args) {
        String[] s = {"one", "two", "three",};
        for (int i = 0; i < s.length; i++) {
            System.out.println("s[" + i + "] = " + s[i]);
        }
    }
}
