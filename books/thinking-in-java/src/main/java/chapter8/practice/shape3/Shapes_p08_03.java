package chapter8.practice.shape3;
/**
 * Add a new method in the base class of Shape.java that prints a message ,but
 * don't override it in the derived classes. Explain what hapens. Now override
 * it in one of the derived classes but not the others and see what happens.
 * Finally override it in all the derived classes.
 * @author lh
 */
public class Shapes_p08_03 {
    private static RandomShapeGenerator gen = new RandomShapeGenerator();
    public static void main(String[] args){
        Shape[] s = new Shape[10];
        // fill up the array with shapes:
        for(int i = 0; i < s.length; i++) {
            s[i] =gen.next();
        }
        // make polymorphic method calls:
        for (Shape shape : s) {
            shape.draw();
            shape.amend();
        }

    }
}
