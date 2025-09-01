package chapter5.practice;

/**
 * Create a main() that varargs instead of the ordinary main() syntax. Print
 * all the element in the resulting args array. Test it with without various numbers of
 * command-line  arguments.
 * @author liu.hua
 */
public class VarargEx_p05_20 {
    public static void main(String[] args) {
        for (String s : args) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
