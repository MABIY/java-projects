package chapter8.shape;

import static net.mindview.util.Print.print;

/**
 * @author lh
 */
public class Traiangle extends Shape {
    @Override
    public void draw() {
        print("Traiangle.draw");
    }

    @Override
    public void erase() {
        print("Traiangle.erase");
    }
}
