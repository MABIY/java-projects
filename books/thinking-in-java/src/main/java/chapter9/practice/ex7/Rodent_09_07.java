package chapter9.practice.ex7;

import java.util.Random;

import static org.greggordon.tools.Print.println;

/**
 * Modify Exercise 9 in the polymorphism chapter so that Rodent is an interface.
 * @author lh
 */

class RandomRodentGenerator{
    private Random rand =  new Random();
    public Rodent next(){
        switch(rand.nextInt(3)){
            default:
            case 0: return new Mouse();
            case 1: return new Rat();
            case 2: return new Squirrel();

        }
    }
}
interface Rodent {
    String name = "Rodent";

    void eat();

    void run();

    void sleep();

    @Override
    String toString();
}

class Mouse implements Rodent {
    private String name = "Mouse";

    @Override
    public void eat() {
        println("Mouse.eat()");
    }

    @Override
    public void run() {
        println("Mouse.run()");
    }

    @Override
    public void sleep() {
        println("Mouse.sleep()");
    }

    @Override
    public String toString() {
        return name;
    }
}

class Rat implements Rodent {
    private String name = "Rat";
    @Override
    public void eat() {
        println("Rat.eat()");
    }

    @Override
    public void run() {
        println("Rat.run()");
    }

    @Override
    public void sleep() {
        println("Rat.sleep()");
    }

    @Override
    public String toString() {
        return name;
    }
}

class Squirrel implements Rodent {
    private String name = "Squirrel";

    @Override
    public void eat() {
        println("Squirrel.eat()");
    }

    @Override
    public void run() {
        println("Squirrel.run()");
    }

    @Override
    public void sleep() {
        println("Squirrel.sleep()");
    }

    @Override
    public String toString() {
        return name;
    }
}
/**
 * @author lh
 */
public class Rodent_09_07 {
   private static final RandomRodentGenerator GEN = new RandomRodentGenerator();
   public static void main(String[] args){
       // Error: cannot instantiate (abstract) interface:
//       Rodent x =new Rodent();
       //But ok to create array of implementing objects:
        Rodent[] rodents = new Rodent[10];
        for (Rodent r : rodents) {
            r =GEN.next();
            println(r +": ");
            r.eat();
            r.run();
            r.sleep();

        }
   }
}
