package com.lh.javabase.function;

import java.util.function.Function;

/**
 * @author liu.hua
 */
public class FunctionChaining {
    public static void main(String[] args) {
        Function<String, Integer> strToInt = Integer::parseInt;

        Function<Integer, Integer> addTen = num -> num + 10;

        Function<Integer, String> intToStr = String::valueOf;

        Function<String, String> chain = intToStr.compose(addTen).compose(strToInt); String result = chain.apply("5"); System.out.println(result);
    }
}
