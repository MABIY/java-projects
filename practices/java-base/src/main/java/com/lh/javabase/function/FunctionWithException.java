package com.lh.javabase.function;

import java.util.function.Function;

/**
 * @author liu.hua
 */
@FunctionalInterface
interface ThrowingFunction <T,R,E extends Exception> {
    R apply(T t) throws E;
}
/**
 * @author liu.hua
 */
public class FunctionWithException {
    static <T, R, E extends Exception> Function<T, R> wrap(ThrowingFunction<T, R, E> throwingFunction) {
        return t -> {
            try {
                return throwingFunction.apply(t);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static void main(String[] args) {
        Function<String, Integer> safeParser = wrap(Integer::parseInt);
        Integer result = safeParser.apply("123i");
        System.out.println(result);
    }
}
