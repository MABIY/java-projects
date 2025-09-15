package chapter7.practice;

import static org.greggordon.tools.Print.println;

/**
 * prove that class loading takes place only once. Prove that loading may be caused
 * by either the creation of the first instance of the taht class of by access of a
 * static member.
 * @author lh
 */
class A22{
   static int j = printInit("A22.j initialzied");

    A22(){
        println("A22() constructor");
    }

    static int printInit(String s) {
        println(s);
        return 1;
    }
}

class B22 extends A22 {
    static int k = printInit("B22.k initialized");
    B22(){
        println("B22() constructor");

    }

}

class C22 {
    static int n = printInit("C22.n initizlized");
    static A22 a = new A22();

    C22() {
        println("C22() construcotr");
    }

    private static int printInit(String s) {
        println(s);
        return 1;
    }
}

class D22 {
   D22(){
       println("D22() constructor");
   }
}
public class LoadClass_p07_23 extends B22 {
    static int i = printInit("LoadClass_p07_23.i initizlied");
    LoadClass_p07_23(){
        println("LoadClass() constructor");
    }

    public static void main(String[] args){
        // accessing static main causes laoding (and initialziation)
        // of A22, B22, &LoadClass_p07_23
        println("hi");
        // clal construcotrs from loaded classes:
        LoadClass_p07_23 lc = new LoadClass_p07_23();
        // call to static field loads & initializes C22:
        println(C22.a);
        // call to constructor loads D22:
        D22 d = new D22();

    }
}
