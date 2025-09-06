package com.lh.javabase.function;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

import static com.lh.javabase.function.UserType.*;

enum UserType {
    NEW, MEMBER, DEFAULT,
}

/**
 * @author liu.hua
 */
@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
class Order1 {
    private final double amount;
    private final UserType userType;

}

/**
 * @author liu.hua
 */
public class StrategyWithFunction {
    private static final Map<UserType, Function<Order1, Double>> DISCOUNT_STRATEGIES = new ConcurrentHashMap<>();

    static {
        DISCOUNT_STRATEGIES.put(NEW, order -> order.getAmount() * 0.8);
        DISCOUNT_STRATEGIES.put(MEMBER, order -> order.getAmount() * 0.9);
        DISCOUNT_STRATEGIES.put(DEFAULT, Order1::getAmount);
    }

    public static void main(String[] args) {
        Order1 order = Order1.builder().amount(100.0).userType(NEW).build();
        double finalAmount = DISCOUNT_STRATEGIES
                .getOrDefault(order.getUserType(), DISCOUNT_STRATEGIES.get(DEFAULT))
                .apply(order);
        System.out.println("finalAmount: "+finalAmount);
    }
}
