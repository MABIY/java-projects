package chapter7.practice;

import static org.greggordon.tools.Print.println;

/**
 * Modify Exercise 16 so that Frog overrides that method definitions from
 * the base class (provides new definitions using the same method
 * signatures).Note what happens in main().
 * @author lh
 */
class Amphibian17{
    protected void swim(){
        println("Amphibian swim");
    }

    protected void speak(){
        println("Amphibian speak");
    }

    void eat(){
        println("Amphibian eat");
    }

    static void grow(Amphibian17 a){
        println("Amphibian grow");
        a.eat();
    }
}
class Frog17 extends Amphibian17{
    @Override
    protected void swim() {
        println("Frog swim");
    }

    @Override
    protected void speak() {
        println("Frog speak");
    }

    @Override
    void eat() {
        println("Frog eat");
    }

    static void grow(Amphibian17 a) {
        println("Frog grow");
        a.eat();
    }
}
public class Po7_18 {
    public static void main(String[] args){
       Frog17 f =new Frog17();
       // call overridden base-class methods
        f.swim();
        f.speak();
        f.eat();
        // upcast Frog17 to Amphibian17 argument:
        Frog17.grow(f);
       // upcast.Frog17 to Amphibian and call Amphibian method:
        Amphibian17.grow(f);
    }
}
