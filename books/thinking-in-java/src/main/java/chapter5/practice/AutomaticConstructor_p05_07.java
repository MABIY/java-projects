package chapter5.practice;

/**
 * Create a class without a constructor, and then create an obejct of that
 * class in main() to verify that the default constructor is automatically
 * synthesized
 * @author liu.hua
 */
class Aso {
   void bark(){
       System.out.println("woof");
   }
}
public class AutomaticConstructor_p05_07 {
    public static void main(String[] args) {
        Aso a = new Aso();
        a.bark();
    }
}
