package chapter8.practice.shape4;

import static net.mindview.util.Print.print;

/**
 * @author lh
 */
public class Rectangle extends Shape {
    @Override
    public void draw() {
        print("Rectangle.draw()");
    }

    @Override
    public void erase() {
        print("Rectangle.erase()");
    }

    @Override
    public void amend() {
        print("Rectangle.amend()");

    }
}
