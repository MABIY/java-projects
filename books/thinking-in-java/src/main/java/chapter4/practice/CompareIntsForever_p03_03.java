package chapter4.practice;

import java.util.Objects;
import java.util.Random;

/**
 * @author lh
 */
public class CompareIntsForever_p03_03 {
    public static void main(String[] args) {
        Random random = new Random();

        Integer index =null, first = null, second = null;
        while(true) {
            if (Objects.isNull(index)) {
                index = 0;
            } else {
                index++;
            }
            if(Objects.isNull(first)) {
                first = random.nextInt();
            } else if(Objects.isNull(second)) {
                second = random.nextInt();
            } else {
                first = second;
                second = random.nextInt();
            }

            if(!Objects.isNull(second)) {
                if(first > second) {
                    System.out.println("index: " + index + first + " > " + second);
                }else if(first < second) {
                    System.out.println("index: " + index + first + " < " + second);
                } else {
                    System.out.println("index: " + index + first + " == " + second);
                }
            }
        }
    }
}
