package chapter7.practice;

import static org.greggordon.tools.Print.println;

/**
 * prove the  previous sentence.  (Even if you don't create a constructor for
 * Cartoon(), the compiler will synthesize a default constructor for you that
 * calls the base-class constructor.)
 * @author lh
 */
class Art {
    Art() {
        println("Art constructor");
    }
}

class Drawing extends Art {
    Drawing() {
        println("Drawing constructor");
    }
}

/**
 * @author lh
 */
public class Cartoon2_p07_03 extends Drawing {
    public static void main(String[] args) {
        Cartoon2_p07_03 x = new Cartoon2_p07_03();
    }
}
