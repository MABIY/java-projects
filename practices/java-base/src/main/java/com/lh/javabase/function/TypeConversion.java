package com.lh.javabase.function;

import java.util.function.Function;

/**
 * @author liu.hua
 */
public class TypeConversion {
    public static final Function<String, Integer> STRING_TO_INTEGER = str -> {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return 0;
        }
    };

    public static void main(String[] args) {
        String numStr = "123i";

        Integer num = STRING_TO_INTEGER.apply(numStr);
        System.out.println(num);
    }
}

