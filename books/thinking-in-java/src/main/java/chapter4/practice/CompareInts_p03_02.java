package chapter4.practice;

import java.util.Objects;
import java.util.Random;

import static net.mindview.util.Print.print;

/**
 * Write a program that generates 25 random int values. For each value, use
 * an if-else statement to classify it as greater than, less than or equal to a
 * second randomly generated value.
 *
 * @author lh
 */
public class CompareInts_p03_02 {
    public static void main(String[] args) {
//        Random rand1 = new Random();
//        Random rand2 = new Random();
//        for (int i = 0; i < 25; i++) {
//            int x = rand1.nextInt();
//            int y = rand2.nextInt();
//            if (x < y) {
//                print(x + "< " + y);
//            } else if (x > y) {
//                print(x + " > " + y);
//            } else {
//                print(x + " = " + y);
//            }
//        }
//
//        Random rand3 = new Random();
//        Random rand4 = new Random();
//        for(int i = 0; i < 25 ; i++){
//            int x = rand3.nextInt(10);
//            int y = rand4.nextInt(10);
//            if (x < y) {
//                print(x + "< " + y);
//            } else if (x > y) {
//                print(x + " > " + y);
//            } else {
//                print(x + " = " + y);
//            }
//        }
        test();

    }

    public static void test(){
        Random random = new Random();
        Integer first = null, second = null;
        for(int i = 0 ; i< 25 ;i ++){
            if (Objects.isNull(first)) {
                first = random.nextInt();
            }else if(Objects.isNull(second)) {
                second = random.nextInt();
            } else {
                first = second;
                second = random.nextInt();
            }

            if(!Objects.isNull(second)){
                if (first > second) {
                    System.out.println("index: " + i + " : " + first + " > " + second);
                } else if (first < second){
                    System.out.println("index: " + i + " : " + first + " < " + second);
                }else {
                    System.out.println("index: " + i + " : " + first + " = " + second);
                }
            }
        }
    }
}
