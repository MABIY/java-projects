package chapter8.practice;

import chapter8.practice.shape3.RandomShapeGenerator;

import java.util.Random;

import static org.greggordon.tools.Print.println;

/**
 * Create an inheritance hierarchy or Rodent:Mouse, Gerbil,Hamster ,etc. Inteh
 * base class ,provide methods that are common to all Rodents, and override these
 * in the derived classes to perform different behaviors depending on the
 * specific type of Rodent. Create an array of Rodent, fill it with differnt
 * specific types of Rodents, and call your base-class methods to see what happens.
 * @author lh
 */
class RandomRodentGenerator{
    private Random random  = new Random();
    public Rodent next(){
        switch (random.nextInt(3)){
            default:
            case 0:
                return new Mouse();
            case 1:
                return new Rat();
            case 2:
                return new Squirrel();
        }
    }
}
class Rodent{
    private String name = "Rodent";
    protected void eat(){
        println("Rodent.eat()");
    }

    protected void run(){
        println("Rodent.run()");
    }
    protected void sleep(){
        println("Rodent.sleep()");
    }

    @Override
    public String toString() {
        return name;
    }
}
class Mouse extends Rodent{
    private String name = "Mouse";
    protected void eat(){
        println("Mouse.eat()");
    }

    protected void run(){
        println("Mouse.run()");
    }
    protected void sleep(){
        println("Mouse.sleep()");
    }

    @Override
    public String toString() {
        return name;
    }
}
class Rat extends Rodent{
    private String name = "Rat";
    protected void eat(){
        println("Rat.eat()");
    }

    protected void run(){
        println("Rat.run()");
    }
    protected void sleep(){
        println("Rat.sleep()");
    }

    @Override
    public String toString() {
        return name;
    }
}
class Squirrel extends Rodent{
    private String name = "Squirrel";
    protected void eat(){
        println("Squirrel.eat()");
    }

    protected void run(){
        println("Squirrel.run()");
    }
    protected void sleep(){
        println("Squirrel.sleep()");
    }

    @Override
    public String toString() {
        return name;
    }
}

public class Rodent_p08_09 {
    private static RandomRodentGenerator gen = new RandomRodentGenerator();
    public static void main(String[] args){
        Rodent[] rodents = new Rodent[10];

        for (Rodent r : rodents) {
            r = gen.next();
            println(r + ": ");
            r.eat();
            r.run();
            r.sleep();
        }
    }

}
