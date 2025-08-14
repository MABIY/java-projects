package chapter4.practice;

import static net.mindview.util.Print.print;

/**
 * Modify exercise 1 so that the program exits by using the break keyword at
 * at value 99. Try using return instead.
 *
 * @author lh
 */
public class IntCount_04_07 {
    static void count1(int n) {
        for (int i = 0; i < n; i++) {
            print(i + 1);
        }
    }

    static void count2(int n) {
        for (int i = 0; i < n; i++) {
            print(i + 1);
            if (i == 98) break;
        }
    }
    static void count3(int n) {
        for(int i= 0; i< n; i++){
            print(i+1);
            if(i == 98)
                return;

        }
    }
    public static void main(String[] args){
        count1(100);
        count2(100);
        count3(100);
    }
}
