package chapter7.practice;

import static net.mindview.util.Print.print;

/**
 * in Beetle.java, inherit a specific type beetle form class Beetle, following
 * the same format as the existing classes. Trace the expain the output
 * @author lh
 */

class Insect{
    private int i =9;
    protected int j;
    Insect(){
        print("i = " + i + ", j = " + j);
        j = 39;
    }

    private static int x1 = printInit("static Insect.x1 initizlized");

     static int printInit(String s) {
        print(s);
        return 47;
    }

}

class Beetle extends Insect{
    private int k =printInit("Beetle.k initialized");
    public Beetle(){
        print("k = " + k);
        print("j = " + j);
    }

    private static int x2 = printInit("static Beetle.x2 initizlied");
}
public class Scarab_p07_24 extends Beetle {
    private int n = printInit("Scarab_p07_24.n initizlied");

    public Scarab_p07_24() {
        print("n = " + n);
        print("j = " + j);
    }

    private static int x3 = printInit("static Scarab_p07_24.x3 initialzied");
    public static void main(String[] args){
        print("Scarab_p07_24 constructor");
        Scarab_p07_24 sc = new Scarab_p07_24();
    }
}
