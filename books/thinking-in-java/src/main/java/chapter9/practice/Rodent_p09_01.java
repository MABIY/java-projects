package chapter9.practice;

import java.util.Random;

import static org.greggordon.tools.Print.println;

/**
 * Modify chapter 9 in the previous chapter so that Rodent is an abstract class.
 * Make the methods of Rodent abstract whatever possible.
 * @author lh
 */

class RandomRodentGenerator{
    private Random rand = new Random();
    public Rodent next(){
        switch (rand.nextInt(3)){
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
abstract class Rodent {
    private String name = "Rodent";

    protected abstract void eat();

    protected abstract void run();

    protected abstract void sleep();

    @Override
    public abstract String toString();
}

class Mouse extends Rodent{
    private String name = "Mouse";

    @Override
    protected void eat() {
        println("Mouse.eat()");
    }

    @Override
    protected void run() {
        println("Mouse.run()");

    }

    @Override
    protected void sleep() {
        println("Mouse.sleep()");

    }

    @Override
    public String toString() {
        return name;
    }
}

class Rat extends Rodent{
    private String name = "Rat";
    @Override
    protected void eat() {
        println("Rat.eat()");

    }

    @Override
    protected void run() {
        println("Rat.run()");

    }

    @Override
    protected void sleep() {
        println("Rat.sleep()");
    }

    @Override
    public String toString() {
        return name;
    }
}

class Squirrel extends Rodent{
    private String name = "Squirrel";

    @Override
    protected void eat() {
        println("Squirrel.eat()");
    }

    @Override
    protected void run() {
        println("Squirrel.run()");

    }

    @Override
    protected void sleep() {
        println("Squirrel.sleep()");
    }

    @Override
    public String toString() {
        return name;
    }
}

public class Rodent_p09_01 {
   private static RandomRodentGenerator gen = new RandomRodentGenerator();
   public static void main(String[] args){
       // Error: cannot instantiate abstract class:
//        Rodent x = new Rodent();
       Rodent[] rodents = new Rodent[10];
       for (Rodent r : rodents) {
            r = gen.next();
            println(r +":");
            r.eat();
            r.run();
            r.sleep();
       }
   }
}