package chapter7.practice;

import static org.greggordon.tools.Print.println;

/**
 * create two classes, A and B, with default constructors (empty argument
 * lists) that announce themselves. Inherit a new class called C from A, and
 * create a member of class B inside C. DO not create a constructor for C. Create
 * an object of class C and observe the results.
 * @author lh
 */
class A1 {
    A1(){
        println("A()");
    }
}

class B1 extends A1{
    B1(){
        println("B()");
    }
}
/**
 * @author lh
 */
public class C_p07_05 extends A1{
    // will then construct another A and then a B
    B1 b1 = new B1();

    public static void main(String[] args){
        C_p07_05 c= new C_p07_05();
    }
}
