package chapter5.practice;

/**
 * Write a switch statement for the num in the previous example. For each
 * case, output a description of that particular currency.
 *
 * @author liu.hua
 */
public class Wallet_p05_22 {
    EnumEx_p05_21.Bills b;

    public static void main(String[] args) {
        for (EnumEx_p05_21.Bills b : EnumEx_p05_21.Bills.values()) {
            System.out.print("Worth: ");
            switch (b) {
                case ONE:
                    System.out.println("$1");
                    break;
                case FIVE:
                    System.out.println("$5");
                    break;
                case TEN:
                    System.out.println("$10");
                    break;
                case TWENTY:
                    System.out.println("$20");
                    break;
                case FIFTY:
                    System.out.println("$50");
                    break;
                case HUNDRED:
                    System.out.println("$100");
                    break;
                default:
                    break;
            }
        }
    }
}
