package chapter5.practice;

/**
 * Add an overloaded constructor to the previous exercise that takes a String argument
 * and prints it along with your message.
 * @author liu.hua
 */

class Kabayo2 {
   Kabayo2() {
       System.out.println("isa lang kabayo");
   }

   Kabayo2(String s) {
       System.out.println("isa lang kabayo " +s);
   }
}
public class DefaultConstructorTest2_p05_04 {
    public static void main(String[] args) {
        Kabayo2 k = new Kabayo2();
        Kabayo2 k2 = new Kabayo2("tumutugtog ng giatar");
    }
}
