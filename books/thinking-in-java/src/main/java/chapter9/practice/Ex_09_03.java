package chapter9.practice;

import static org.greggordon.tools.Print.println;

/*
 * Create a base class with an abstract print() method that is overridden in a derived
 * class. The overridden version of the method prints the value of an int variable defined
 * in the derived class. At the point of definition of this variable, give it nonzero value.
 * In the base-class constructor, call this method, In main(), create an object of the derived
 * type, and then call its print() method. Explain the results
 * @author lh
 */
abstract class Dad {
    Dad() {
        print();
    }

    protected abstract void print();
}

class Son extends Dad {
    private int i = 1;

    @Override
    protected void print() {
        println("Son.i = " + i);
    }
}

public class Ex_09_03 {
    /*   Process of initialization:
     * 1.Storage for Son s allocated and initialized to binary zero
     * 2. Dad() called
     * 3. Son.print() called in Dad() (s.i=0)
     * 4.Member initializers called in order(s.i=1)
     * 5.Body of Son() called
     */
    public static void main(String[] args) {
        Son s = new Son();
        s.print();
    }
}
