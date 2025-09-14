package chapter7.practice;

import static org.greggordon.tools.Print.println;

/**
 * Modify Exercise 5 so that A and B constructors with arguments instead
 * of default constructors. Write constructor for C and perform all
 * initialization within C's constructor.
 * @author lh
 */
class A2 {
    A2(char c, int i){
        println("A(char,int)");
    }
}
class B2 extends A2{
    B2(String s ,float f){
        super(' ',0);
        println("B(String,float)");
    }
}
/**
 * @author lh
 */
public class Po7_07 extends A2 {
    private char c;
    private int i;
    Po7_07(char a,int j){
        super(a,j);
        c = a;
        i = j;
    }
    // will then construct another A and then a B
    B2 b = new B2("hi",1f);
    public static void main(String[] args){
        // Will construct an A first
        Po7_07 c = new Po7_07('b',2);
    }
}
