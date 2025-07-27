package chapter3;

import javax.swing.*;

import static net.mindview.util.Print.print;

/**
 * Passing objects to methods may not be
 * what you're used to
 */
class Letter{
    char c;
}
public class PassObject {
    static void f(Letter y){
        y.c = 'z';
    }

    public static void main(String[] args) {
        Letter x = new Letter();
        x.c = 'a';
        print("1: x.c: " + x.c);
        f(x);
        print("2: x.c: " + x.c);
    }
}
