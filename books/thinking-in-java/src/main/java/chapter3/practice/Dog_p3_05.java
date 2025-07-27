package chapter3.practice;

import javax.swing.*;

import static net.mindview.util.Print.print;

/**
 * @author lh
 */
class  Dog{
    String name;
    String says;

    public void setName(String name) {
        this.name = name;
    }

    public void setSays(String says){
        this.says = says;
    }
    void showName(){
        print(name);
    }
    void speak() {
        print(says);
    }
}
public class Dog_p3_05 {
    public static void main(String[] args) {
        Dog spot = new Dog();
        spot.setName("Spot");
        spot.setSays("Ruff!");
        Dog scruffy = new Dog();
        scruffy.setName("Scruffy");
        scruffy.setSays("Wurf!");
        spot.showName();
        spot.speak();
        scruffy.showName();
        scruffy.speak();
    }
}
