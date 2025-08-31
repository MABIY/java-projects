package chapter5.practice;

/**
 * Create a class with a String that is initialized using instance  initialization
 * @author liu.hua
 */
class Tester1{
    String s;
    {
        s = "Initializing string in  Tester1";
        System.out.println(s);
    }
    Tester1(){
        System.out.println("Tester()");
    }

}
public class InstanceClauseTest_p05_15 {
    public static void main(String[] args) {
        new Tester1();
    }
}
