package com.lh.javabase.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @author liu.hua
 */
public class StreamWithFunction {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("1", "2", "3", "4");

        Function<String, Integer> toInt = Integer::parseInt;

        List<String> result = stringList.stream()
                .map(toInt)
                .filter(num-> num %2 ==0)
                .map(String::valueOf)
                .toList();

        System.out.println(result);
    }
}
