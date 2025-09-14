package chapter7.practice;

import static org.greggordon.tools.Print.println;

/**
 * Create a class with a method that is overloaded three times, Inherit a new
 * class, add a new overloading of the method. and show that all four methods are
 * available in the derived class.
 * @author lh
 */
class ThreeWay{
    void number(byte b) {
        println(b);
    }
    void number(short s) {
        println(s);
    }
    void number(int i) {
        println(i);
    }
}
public class Overload_p07_13 extends ThreeWay{
   void number(float f) {
       println(f);
   }
   public static void main(String[] args){
       Overload_p07_13 ov = new Overload_p07_13();
       ov.number((byte)0);
       ov.number((short)1);
       ov.number(2);
       ov.number(3.0f);
   }
}
