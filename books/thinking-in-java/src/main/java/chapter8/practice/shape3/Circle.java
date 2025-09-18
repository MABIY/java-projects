package chapter8.practice.shape3;

import static net.mindview.util.Print.print;

/**
 * @author lh
 */
public class Circle extends Shape {
    @Override
    public void draw() {
        print("Circle.draw()");
    }

    @Override
    public void erase() {
        print("Circle.erase()");
    }

    @Override
    public void amend() {
        print("Circle.amend()");

    }
}
