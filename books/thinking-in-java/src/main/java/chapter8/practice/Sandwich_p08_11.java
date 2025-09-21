package chapter8.practice;

import chapter8.Sandwich;

import static net.mindview.util.Print.print;

/**
 * Add class Pickle to Sandwich.java
 * @author lh
 */
class Meal{
    Meal(){
        print("Meal()");
    }
}

class Bread{
    Bread() {
        print("Bread()");
    }
}

class Cheese{
    Cheese() {
        print("Cheese()");
    }
}

class Lettuce{
    Lettuce(){
        print("Lunch()");
    }
}

class Pickle{
    Pickle(){
        print("Pickle()");
    }
}

class Lunch extends Meal{
    Lunch() {
        print("Lunch()");
    }
}

class PortableLunch extends Lunch{
    PortableLunch(){
        print("PortableLunch()");
    }
}

public class Sandwich_p08_11 extends PortableLunch{
    private Bread b = new Bread();
    private Cheese c = new Cheese();
    private Pickle p = new Pickle();
    private Lettuce l = new Lettuce();

    public Sandwich_p08_11() {
        print("Sandwich_p08_11()");
    }

    public static void main(String[] args){
        new Sandwich_p08_11();
    }
}
