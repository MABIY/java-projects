package chapter8.practice.shape4;

/**
 * Add a new shape to Shapes.java and verify in main() that polymorphism works
 * for you new  type as is does for the old types:
 * @author lh
 */
public class Shapes_p08_04 {
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
