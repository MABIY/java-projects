package chapter8.practice.shape4;

import java.util.Random;

/**
 * @author lh
 */
public class RandomShapeGenerator {
    private Random rand = new Random();
    public Shape next(){
        switch (rand.nextInt(4)){
            default:
            case 0:
                return new Circle();
            case 1:
                return new Square();
            case 2:
                return new Triangle();
            case 3:
                return new Rectangle();

        }
    }
}
