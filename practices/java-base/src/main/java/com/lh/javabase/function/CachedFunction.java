package com.lh.javabase.function;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/**
 * @author liu.hua
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CachedFunction {
    private static final Map<Object, Object> CACHE = new ConcurrentHashMap<>();

    public static <T,R> R queryIfAbsent(T key, Function<T,R> queryFunc){
        if(CACHE.containsKey(key)){
            @SuppressWarnings("unchecked")
            R r = (R) CACHE.get(key);
            return r;
        }

        R result = queryFunc.apply(key);
        CACHE.put(key, result);

        return result;
    }

    public static void main(String[] args) {
        Function<Long, String> dbQuery = id -> {
            System.out.println("Executing query fo id:" + id);

            return "User_" + id;
        };

        String user1 = queryIfAbsent(1L, dbQuery);

        String user2 = queryIfAbsent(1L, dbQuery);

        System.out.println(user1);
        System.out.println(user2);

    }

}
