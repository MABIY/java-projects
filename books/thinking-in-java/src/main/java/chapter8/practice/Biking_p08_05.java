package chapter8.practice;

import static org.greggordon.tools.Print.println;

/**
 * Starting from Exercise 1, add a wheels() method in Cycle, which return the
 * number of wheels. Modify ride() to call wheels() and verify that polymorphism
 * works.
 * @author lh
 */
class Cycle5 {
    private String name = "Cycle";
    private int wheels = 0;

    public static void travel(Cycle5 c) {
        println("Cycle.ride()" + c);
    }

    public int wheels() {
        return wheels;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

class Unicycle5 extends Cycle5{
    private String name = "Unicycle";
    private int wheels = 1;

    @Override
    public int wheels() {
        return wheels;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

class Bicycle5 extends Cycle5{
    private String name = "bicycle";
    private int wheels = 2;

    @Override
    public int wheels() {
        return wheels;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

class Tricycle5 extends  Cycle5 {
    private String name = "Tricycle";
    private int wheels = 3;

    @Override
    public int wheels() {
        return wheels;
    }

    @Override
    public String toString() {
        return name;
    }
}

/**
 * @author lh
 */
public class Biking_p08_05 {
    public static void ride(Cycle5 c){
        c.travel(c);
        println("wheels: " + c.wheels());
    }
    public static void main(String[] args){
        Unicycle5 u = new Unicycle5();
        Bicycle5 b = new Bicycle5();
        Tricycle5 t = new Tricycle5();
        //upcast to Cycle
        ride(u);
        ride(b);
        ride(t);
    }
}
