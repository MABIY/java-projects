package chapter9.practice.ex8;

import static net.mindview.util.Print.print;

/**
 * In polymorphism.Sandwich.java, create an interface called FastFood (with
 * appropriate methods) and change Sandwich so that is also implements FastFood.
 * @author lh
 */

interface FastFood{
    void cheeseburger();
    void fries();
    void softDrink();
}
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
    Cheese(){
        print("Cheese()");
    }
}

class Lettuce {
    Lettuce(){
        print("Lettuce()");
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

public class SandWich_p09_08 extends PortableLunch implements FastFood{
    private Bread b = new Bread();
    private Cheese c = new Cheese();
    private Lunch l = new Lunch();

    public SandWich_p09_08() {
        print("SandWich_p09_08()");
    }

    public void cheeseburger(){
        print("Cheeseburger");
    }

    public void fries(){
        print("Fries");
    }

    public void softDrink(){
        print("Soft Drink");
    }

    public static void main(String[] args){
        FastFood s = new SandWich_p09_08();
        s.cheeseburger();
        s.fries();
        s.softDrink();
    }
}
