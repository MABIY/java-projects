package chapter3;

/**
 * @author lh
 * "e" means "1o to the power."
 */
public class Exponents {
    public static void main(String[] args) {
        //Uppercase and lowercase 'e' are the same
        float expFloat = 1.39e-43f;
        System.out.println(expFloat);
        double expDouble = 47e47d; //'d' is optional
        double expDouble2 = 47e47; // Automatically double
        System.out.println(expDouble);
        Exponents exponents = new Exponents();
    }
}
