package chapter5;

/**
 * @author liu.hua
 */
public class MethodInit2 {
    int i = f();
    int j = g(i);

    int g(int n) {
        return n * 10;
    }

    int f() {
        return 1;
    }

}
