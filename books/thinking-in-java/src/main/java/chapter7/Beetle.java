package chapter7;

import static net.mindview.util.Print.print;

/**
 * The full process of initialization.
 * @author lh
 */
class Insect {
    private static int x1 = printInit("static Insect.x1 initialized");
    protected int j;
    private int i = 9;

    Insect() {
        print("i = " + i + ". j = " + j);
        j = 39;
    }

    static int printInit(String s) {
        print(s);
        return 47;
    }
}

public class Beetle extends Insect{
   private int k = printInit("Beetle.k initialized");

    public Beetle() {
        print("k = " + k);
        print("j = " + j);
    }
    private static int x2 = printInit("static Beetle.x2 initialized");
    public static void main(String... args){
        print("Beetle constructor");
        Beetle b = new Beetle();
    }
}
