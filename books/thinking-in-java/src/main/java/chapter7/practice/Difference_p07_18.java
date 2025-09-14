package chapter7.practice;

import java.util.Random;

import static org.greggordon.tools.Print.println;

/**
 * Create a class with a static final field and a final field and demonstrate
 * the difference between the two.
 * @author lh
 */
class Test{
    Test(){
        println("Test()");
    }
}
public class Difference_p07_18 {
    private String name;

    public Difference_p07_18(String name) {
        this.name = name;
    }
    static final Test sft = new Test(); // constant reference address
    private final Test ft = new Test();
    static final String SFS = "static final"; // class constant
    private final String fs = "final";
    private static Random rand =new  Random();
    static final int SFI = rand.nextInt(); //class constant
    private final int fi = rand.nextInt();

    @Override
    public String toString() {
        return (name + ": " + sft + ", " + ft + ", " + SFS + ", " + fs + ", " + SFI + ", " + fi);
    }
    public static void main(String[] args){
        Difference_p07_18 d1 = new Difference_p07_18("d1");
        Difference_p07_18 d2 = new Difference_p07_18("d2");
        Difference_p07_18 d3 = new Difference_p07_18("d3");
        println(d1);
        println(d2);
        println(d3);
    }
}
