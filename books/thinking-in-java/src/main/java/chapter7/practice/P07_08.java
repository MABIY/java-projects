package chapter7.practice;

import static org.greggordon.tools.Print.println;

/**
 * Create a base class with only a non-default constructor, and a derived class
 * with both a default  (no-arg) and non-default constructor. IN the derived-class
 * constructors, call the base-class constructor
 * @author lh
 */

class A3{
    A3(char c ,int i){
        println("A(char,int)");
    }

}
public class P07_08 extends A3 {
    private char c;
    private int i;
    P07_08(){
        super('z',3);
        println("Ex8(0)");
    }

    P07_08(char a,int j){
        super(a,j);
        c = a;
        i = j;
        println("Ex8(char,int)");
    }

    public static void main(String[] args){
        P07_08 ex1 = new P07_08();
        P07_08 ex2 = new P07_08('b',2);
    }

}
