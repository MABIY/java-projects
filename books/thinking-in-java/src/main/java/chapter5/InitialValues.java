package chapter5;

import static net.mindview.util.Print.print;

/**
 * Show default initial values.
 *
 * @author liu.hua
 */
public class InitialValues {
    boolean t;
    char c;
    byte b;
    short s;
    int i;
    long l;
    float f;
    double d;
    InitialValues reference;

    public static void main(String[] args) {
        InitialValues iv = new InitialValues();
        iv.printInitialValues();
        /* You should also say:
        new InitialValues().printInitialValues();
        */

    }

    void printInitialValues() {
        print("Data type    Initial values");
        print("boolean  " + t);
        print("char   [" + c + "]");
        print("byte   [" + b + "]");
        print("short   [" + s + "]");
        print("int   [" + i + "]");
        print("long   [" + l + "]");
        print("float   [" + f + "]");
        print("double   [" + d + "]");
        print("reference   [" + reference + "]");
    }

}
