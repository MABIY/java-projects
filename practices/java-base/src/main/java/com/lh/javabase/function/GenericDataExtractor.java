package com.lh.javabase.function;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author liu.hua
 */

@Setter
@Getter
@AllArgsConstructor
class User1{
    private Long id;
}

@Setter
@Getter
@AllArgsConstructor
class Order{
    private Long orderId;
}

/**
 * @author liu.hua
 */
public class GenericDataExtractor {
    public static <T, R> List<R> extract(List<T> list, Function<T, R> extractor) {
        List<R> result = new ArrayList<>();
        for (T item : list) {
            result.add(extractor.apply(item));
        }

        return result;
    }

    public static void main(String[] args) {
        List<User1> users = List.of(new User1(1L), new User1(2L));
        List<Order> orders = List.of(new Order(100L), new Order(101L));

        List<Long> userIds = extract(users, User1::getId);
        List<Long> orderIds = extract(orders, Order::getOrderId);
        System.out.println(userIds);
        System.out.println(orderIds);
    }
}
