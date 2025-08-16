package chapter4.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static net.mindview.util.Print.print;

/**
 * @author lh
 */
public class VampireNumbers {
    // write by me
//    public static void main(String[] args) {
//        for (int i = 1000; i < 9999; i++) {
//            if (i % 100 == 0) {
//                continue;
//            }
//            String value = String.valueOf(i);
//            List<String> intStrings = Arrays.stream(value.split("")).toList();
//            List<List<Integer>> assemble = assemble(intStrings);
//            for (List<Integer> integers : assemble) {
//                Integer i1 = integers.get(0);
//                Integer i2 = integers.get(1);
//                if(i1 * i2 == i){
//                    print(i + "= " + i1 + " * " + i2);
//                }
//            }
//       }
//    }

//    private static List<List<Integer>> assemble(List<String> intStrings) {
//        String one = intStrings.get(0);
//        String two = intStrings.get(1);
//        String three = intStrings.get(2);
//        String four = intStrings.get(3);
//        List<List<Integer>> result = new ArrayList<>();
//        result.add(List.of(Integer.valueOf(one + two), Integer.valueOf(three + four)));
//        result.add(List.of(Integer.valueOf(one + two), Integer.valueOf(four + three)));
//        result.add(List.of(Integer.valueOf(two + one), Integer.valueOf(three + four)));
//        result.add(List.of(Integer.valueOf(two + one), Integer.valueOf(four + three)));
//
//        result.add(List.of(Integer.valueOf(one + three), Integer.valueOf(two + four)));
//        result.add(List.of(Integer.valueOf(one + three), Integer.valueOf(four + two)));
//        result.add(List.of(Integer.valueOf(three + one), Integer.valueOf(two + four)));
//        result.add(List.of(Integer.valueOf(three + one), Integer.valueOf(four + two)));
//
//        result.add(List.of(Integer.valueOf(one + four), Integer.valueOf(two + three)));
//        result.add(List.of(Integer.valueOf(one + four), Integer.valueOf(three + two)));
//        result.add(List.of(Integer.valueOf(four + one), Integer.valueOf(two + three)));
//        result.add(List.of(Integer.valueOf(four + one), Integer.valueOf(three + two)));
//
//        return result;
//    }

    static int a(int i) {
        return i / 1000;
    }
    static int b(int i) {
        return (i % 1000) / 100;
    }

    static int c(int i) {
        return (i % 1000) % 100 / 10;
    }

    static int d(int i) {
        return i % 10;
    }
    static int com(int i, int j) {
        return (i * 10) + j;
    }

    static void productTest(int i,int m ,int n){
        if(m *n == i) System.out.println(i + " = " + m + " * " + n);
    }


    public static void main(String[] args) {
        for (int i = 1001; i < 9999; i++) {
            productTest(i, com(a(i), b(i)), com(c(i), d(i)));
            productTest(i, com(a(i), b(i)), com(d(i), c(i)));
            productTest(i, com(a(i), c(i)), com(b(i), d(i)));
            productTest(i, com(a(i), c(i)), com(d(i), b(i)));
            productTest(i, com(a(i), d(i)), com(b(i), c(i)));
            productTest(i, com(a(i), d(i)), com(c(i), b(i)));

            productTest(i, com(b(i), a(i)), com(c(i), d(i)));
            productTest(i, com(b(i), a(i)), com(d(i), c(i)));
            productTest(i, com(c(i), a(i)), com(b(i), d(i)));
            productTest(i, com(c(i), a(i)), com(d(i), b(i)));
            productTest(i, com(d(i), a(i)), com(b(i), c(i)));
            productTest(i, com(d(i), a(i)), com(c(i), b(i)));
        }
    }

}
