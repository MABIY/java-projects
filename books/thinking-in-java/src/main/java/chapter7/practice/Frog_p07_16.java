package chapter7.practice;

import static org.greggordon.tools.Print.println;

/**
 * Create a class called Amphibian. From this, inherit a class called Frog.
 * Put appropriate methods in the base class. In main(), create a Frog and upcast
 * it to Amphibian, and demonstrate that all the methods still work.
 * @author lh
 */
class Amphibian{
    protected void swim(){
        println("Amphibian swim");
    }

    protected void speak(){
        println("Amphibian speak");
    }

    void eat(){
        println("Amphibian eat");
    }

    static void grow(Amphibian a){
        println("Amphibian grow");
        a.eat();
    }
}
public class Frog_p07_16 extends Amphibian{
    public static void main(String[] args){
        Frog_p07_16 f = new Frog_p07_16();
        // call base-class methods:
        f.swim();
        f.speak();
        f.eat();
        //upcast Frog to Amphibian argument:
        Amphibian.grow(f);
    }
}
