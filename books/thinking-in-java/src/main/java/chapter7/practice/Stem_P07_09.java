package chapter7.practice;

import static org.greggordon.tools.Print.print;
import static org.greggordon.tools.Print.println;

/**
 * Create a class called Root that contains an instance of each of the classes
 * (that you also create) named Component1, Component2,Component3.Derive a
 * class Stem from Root that also contains an instance of each "component." All
 * classes should have default constructors that print a message about that class
 * @author lh
 */
class Component1{
    Component1(){
        println("Component1()");
    }
}
class Component2{
    Component2(){
        println("Component2()");
    }
}
class Component3{
    Component3(){
        println("Component3()");
    }
}

class Root{
    Component1 c1root;
    Component2 c2root;
    Component3 c3root;
    Root(){
        println("Root()");
    }
}
public class Stem_P07_09 extends Root {

    Component1 c1root;
    Component2 c2root;
    Component3 c3root;
    Stem_P07_09(){
        println("Stem()");
    }

    public static void main(String[] args){
        Stem_P07_09 s = new Stem_P07_09();
    }
}
