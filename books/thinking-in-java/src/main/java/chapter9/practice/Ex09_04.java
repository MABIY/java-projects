package chapter9.practice;

import static org.greggordon.tools.Print.println;

/**
 * Create a abstract class with no method. Derive a class and a method.
 * Create a static method that takes a reference to the base class, downcasts
 * it to the derived class, and calls the method. In main(), demonstrate that it
 * works. Now put the abstract declaration for the method in the base class. thus
 * eliminating hte need for the downcast.
 * @author lh
 */
abstract class Dad04{

}
class Son04 extends Dad04{
    protected void print(){
        println("Son");
    }
}
abstract class SecondDad{
    protected abstract void print();
}

class SecondSon extends SecondDad{
    @Override
    protected void print() {
        println("SecondSon");
    }
}
public class Ex09_04 {
   public static void testPrint(Dad04 d )  {
       ((Son04)d).print();
   }

   public static void secondTestPrint(SecondDad sd){
       sd.print();
   }
   public static void main(String[] args){
       Son04 s = new Son04();
       testPrint(s);
       SecondSon ss = new SecondSon();
       secondTestPrint(ss);
   }

}
