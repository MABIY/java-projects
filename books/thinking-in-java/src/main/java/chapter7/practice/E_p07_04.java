package chapter7.practice;

import static org.greggordon.tools.Print.println;

/**
 * Prove that base-class constructor are (a) always called and (b) called before
 * derived-class constructor
 * @author lh
 */
class A {
     A() {
        println("A()");
    }
}

class B extends A1 {
     B() {
         println("B()");
    }
}

class C extends B{
    C(){
     println("C()");
    }
}

class D extends C_p07_05 {
    D(){
        println("D()");
    }

    public static D makeD(){
        return new D();
    }

    public static void main(String[] args){
        D d = new D();
        D d2 = makeD();
    }
}
public class E_p07_04 extends D {
    E_p07_04(){
        System.out.println("E()");
    }

    public static void main(String[] args){
        E_p07_04 e = new E_p07_04();
        // test D:
        D.main(args);
    }

}
