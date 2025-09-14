package chapter7.practice;

import static org.greggordon.tools.Print.println;

/**
 * Modify the previous exercise so that each class only has non-default
 * constructors.
 * @author lh
 */
class Component10_1 {
    Component10_1(byte b) {
        println("Component10_1(byte)");
    }
}

class Component10_2 {
    Component10_2(short s) {
        println("Component10_2(short)");
    }
}

class Component10_3 {
    Component10_3(int i) {
        println("Component3(int)");
    }
}

class Root10 {
    Component10_1 c1root;
    Component10_2 c2root;
    Component10_3 c3root;

    Root10(float f) {
        c1root = new Component10_1((byte) 0);
        c2root = new Component10_2((short) 0);
        c3root = new Component10_3(0);
        println("Root(float)");
    }
}

public class Stem_p07_10 extends Root10 {
    Component10_1 c1stem10;
    Component10_2 c2stem10;
    Component10_3 c3stem10;

    Stem_p07_10(double d) {
        super(2.78f);
        c1stem10 = new Component10_1((byte) 1);
        c2stem10 = new Component10_2((short) 1);
        c3stem10 = new Component10_3(1);
        println("Stem_p07_10(double)");
    }

    public static void main(String[] args) {
        Stem_p07_10 x = new Stem_p07_10(2.78);
    }
}
