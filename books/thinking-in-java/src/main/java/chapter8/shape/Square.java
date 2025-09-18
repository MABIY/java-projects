package chapter8.shape;

import static net.mindview.util.Print.print;

/**
 * @author lh
 */
public class Square extends Shape {
    @Override
    public void draw() {
        print("Square.draw");
    }

    @Override
    public void erase() {
        print("Square.erase");
    }
}
