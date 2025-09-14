package chapter7.practice;

import static org.greggordon.tools.Print.println;

/**
 * Add a proper hierarchy of dispose() methods to all the classes of exercise 9.
 * Ex 8: Create a class called Root that contains an instance of each of the classes
 * (that you also create) named Component1, Component2,Component3. Derive a
 * class Stem from Root that also contains an instance of each "component." All
 * classes should have default constructors that print a message about that class.
 * @author lh
 */
class Component12_1{
   Component12_1() {
        println("Component12_1()");
   }

   void dispose(){
       println("Component12_1.dispose()");
   }
}

class Component12_2{
    Component12_2() {
        println("Component12_2()");
    }

    void dispose(){
        println("Component12_2.dispose()");
    }
}
class Component12_3{
    Component12_3() {
        println("Component12_3()");
    }

    void dispose(){
        println("Component12_3.dispose()");
    }
}

class Root2{
    Component12_1 c1root;
    Component12_2 c2root;
    Component12_3 c3root;
    Root2(){
        println("Root()");
        c1root = new Component12_1();
        c2root = new Component12_2();
        c3root = new Component12_3();
    }

    void dispose(){
        c3root.dispose();
        c2root.dispose();
        c1root.dispose();
        println("Root2.dispose()");
    }


}
public class Stem2_p07_12 extends Root2{
    Component12_1 c1stem;
    Component12_2 c2stem;
    Component12_3 c3stem;
    Stem2_p07_12() {
        println("Stem2_p07_12");
        c1stem = new Component12_1();
        c2stem = new Component12_2();
        c3stem = new Component12_3();
    }
    void dispose(){
        c3stem.dispose();
        c2stem.dispose();
        c1stem.dispose();
        super.dispose();
        println("Stem2_p07_12.dispose()");
    }

    public static void main(String[] args){
        Stem2_p07_12 s = new Stem2_p07_12();
        try{
            // Code and exception handling..
        }finally{
            s.dispose();
        }
    }
}
