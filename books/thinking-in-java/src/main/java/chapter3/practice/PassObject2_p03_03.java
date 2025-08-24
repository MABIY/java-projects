package chapter3.practice;

import static net.mindview.util.Print.print;

/**
 * @author lh
 */
class Box{
    float a;
}
public class PassObject2_p03_03 {
    static void f(Box y){
        y.a = 2.71828f;
    }

    public static void main(String[] args) {
        Box y = new Box();
        y.a = 2.1416f;
        print("1: y.a = " + y.a);
        f(y);
        print("2: y.a = " + y.a);
    }
}
