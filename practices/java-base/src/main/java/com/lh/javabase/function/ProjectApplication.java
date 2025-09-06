package com.lh.javabase.function;

import lombok.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

import static com.lh.javabase.function.UserType.*;

/**
 * @author liu.hua
 */
@Builder
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
class OrderDTO{
    private String orderNo;
    private String userId;
    private double amount;

}


@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
@Builder(toBuilder = true)
class OrderEntity{
    private Long id;
    private String orderNo;
    private Long userId;
    private double finalAmount;
    private double originalAmount;
    private UserType userType;

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", orderNo='" + orderNo + '\'' +
                ", userId=" + userId +
                ", finalAmount=" + finalAmount +
                ", originalAmount=" + originalAmount +
                ", userType=" + userType +
                '}';
    }
}

/**
 * @author liu.hua
 */
public class ProjectApplication {

    private static final Map<UserType, Function<OrderEntity, Double>> DISCOUNT_STRATEGIES = new ConcurrentHashMap<>();
    private static final Function<OrderDTO, OrderEntity> ORDER_DTO_ORDER_ENTITY_FUNCTION;

    static {
        DISCOUNT_STRATEGIES.put(NEW, order -> order.getOriginalAmount() * 0.8);
        DISCOUNT_STRATEGIES.put(MEMBER, order -> order.getOriginalAmount() * 0.9);
        DISCOUNT_STRATEGIES.put(DEFAULT, OrderEntity::getOriginalAmount);
    }

    static {
        Function<OrderDTO, OrderEntity> orderDtoConvertToOrder = dto -> OrderEntity.builder()
                .orderNo(dto.getOrderNo())
                .originalAmount(dto.getAmount())
                .build();

        Function<OrderEntity, OrderEntity> setUserToOrder = orderEntity -> {
            String userIdStr = "123"; // get user from context
            return orderEntity.toBuilder()
                    .userId(Long.parseLong(userIdStr))
                    .userType(MEMBER)
                    .build();
        };

        Function<OrderEntity, OrderEntity> applyDiscount = orderEntity -> {
            double finalAmount =
                    DISCOUNT_STRATEGIES.get(orderEntity.getUserType()).apply(orderEntity);
            return orderEntity.toBuilder().finalAmount(finalAmount).build();
        };

        ORDER_DTO_ORDER_ENTITY_FUNCTION = orderDtoConvertToOrder.andThen(setUserToOrder).andThen(applyDiscount);
    }

    public static void main(String[] args) {
        List<OrderDTO> orderDtos = List.of(
                OrderDTO.builder().orderNo("ORD001").userId("123").amount(100.0).build(),
                OrderDTO.builder().orderNo("ORD002").userId("123").amount(200.0).build()
        );

        List<OrderEntity> orderEntities =
                orderDtos.stream().map(ORDER_DTO_ORDER_ENTITY_FUNCTION).toList();

        System.out.println(orderEntities);
    }
}
