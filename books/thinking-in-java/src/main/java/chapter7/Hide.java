package chapter7;

import static net.mindview.util.Print.print;

/**
 * Overloading a base-class method name in a dervied
 * class does not hide the base-class versions.
 * @author lh
 */
class Homer {
    char doh(char c) {
        print("doh(char)");
        return 'd';
    }

    float doh(float f) {
        print("doh(float)");
        return 1.0f;
    }
}

class Milhouse {}

class Bart extends Homer {
    void doh(Milhouse m) {
        print("doh(Milhouse)");
    }
}

class Lisa extends Homer {
    /**
     *  error: method does not override or implement a method from a supertype
     *     @Override
     *     ^
     * @param m
     */
    //    @Override
    //    void doh(Milhouse m) {}
}

public class Hide {
    public static void main(String[] args) {
        Bart b = new Bart();
        b.doh(1);
        b.doh('x');
        b.doh(1.0f);
        b.doh(new Milhouse());
    }
}
