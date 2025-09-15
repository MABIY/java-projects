package chapter7.practice;

import chapter7.BlankFinal;

/**
 * Create a clas with blank final reference to an object. Perform
 * initialization at the point of definition of the field inside all
 * constructors. Demonstrate the guarantee that the final must be initialized
 * before use, and that it cannot be changed once initialized.
 * @author lh
 */

class Poppet{
   private int i;
   Poppet(int k) {
        i = k;
   }

    @Override
    public String toString() {
        return ("Poppet" + i);
    }
}
public class BlankFinal_p07_19 {
    // Blank final reference
    private final Poppet p;
    public BlankFinal_p07_19(){
        // Initialize blank final reference
       p = new Poppet(1);
    }

    public BlankFinal_p07_19(int x){
        // Initialize blank final reference
        p = new Poppet(x);
    }

    public static void main(String[] args){
        BlankFinal_p07_19 b1 = new BlankFinal_p07_19();
        BlankFinal_p07_19 b2 = new BlankFinal_p07_19();
        // Errors: cannot assign values to final variables p
//        b1.p = new Poppet(2);
//        b2.p = new Poppet(3);
        System.out.println("b1.p: " + b1.p);
        System.out.println("b2.p: " + b2.p);
    }
}
