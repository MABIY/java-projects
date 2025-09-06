package com.lh.javabase.function;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author liu.hua
 */
public class DynamicFunctionSelection {
    enum Operation {ADD,SUBTRACT,MULTIPLY}

    public static void main(String[] args) {
        Map<Operation, Function<Integer[], Integer>> operationMap = new HashMap<>();
        operationMap.put(Operation.ADD, nums -> nums[0] + nums[1]);
        operationMap.put(Operation.SUBTRACT, nums -> nums[0] - nums[1]);
        operationMap.put(Operation.MULTIPLY, nums -> nums[0] * nums[1]);

        Integer result = operationMap.get(Operation.ADD).apply(new Integer[]{3, 5});
        System.out.println(result);
    }
}
