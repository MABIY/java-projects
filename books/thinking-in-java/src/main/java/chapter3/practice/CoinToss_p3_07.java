package chapter3.practice;

import java.util.Random;

import static net.mindview.util.Print.print;

/**
 * @author lh
 */
public class CoinToss_p3_07 {
    public static void main(String[] args) {
        Random rand = new Random();
        int coin = rand.nextInt();
        if(coin % 2 == 0) print("heads");
        else print("tails");
    }
}
