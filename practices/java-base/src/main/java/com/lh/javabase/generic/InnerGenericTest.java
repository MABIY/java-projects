package com.lh.javabase.generic;

/**
 * <pre>
 *     public InnerGenericTest<T> stringValue(){
 *         InnerGenericTest<T> t = (InnerGenericTest<T>) stringValue;
 *         return t;
 *     }
 * </pre>
 * 内部泛化忽略 T 和 stringValue的类型，内部运行时 当generic都是object
 *
 * @author liu.hua
 */
public class InnerGenericTest<T> {
    private static final InnerGenericTest<?> EMPTY = new InnerGenericTest<>(null);
    private static final InnerGenericTest<?> STRING_VALUE = new InnerGenericTest<>("1231");
    private final T value;

    public InnerGenericTest(T value) {
        this.value = value;
    }

    public static <T> InnerGenericTest<T> empty() {
        @SuppressWarnings("unchecked")
        InnerGenericTest<T> t = (InnerGenericTest<T>) EMPTY;
        return t;
    }

    public static void main(String[] args) {
        InnerGenericTest<Integer> a = new InnerGenericTest<>(1);
        a = a.stringValue();
        // ! Integer value1 = a.value; //只有取出到具体的类型时才报错
        Object value = a.value;
        // java autoboxing happen
        Object o = f();
    }

    private static int f() {
        return 1;
    }

    public InnerGenericTest<T> stringValue() {
        @SuppressWarnings("unchecked")
        InnerGenericTest<T> t = (InnerGenericTest<T>) STRING_VALUE;
        return t;
    }
}
