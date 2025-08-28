package chapter5;

import static net.mindview.util.Print.print;

/**
 * @author liu.hua
 */
public class Flower {
    int petalCount = 0;
    String s = "initial value";
    Flower(int petals){
        petalCount = petals;
        print("Construcor w/ int arg only. petalCount= " + petalCount);
    }
    Flower(String ss){
        s = ss;
        print("Construcotr w/ String arg only, s = " + ss);
    }

    Flower(String ss,int petals){
        this(petals);
//        this(s); Can't call two!
        s = ss; //Another use of "this"
        print("String & int args");
    }
    Flower() {
        this("hi", 47);
        print("default constructor (no args)");
    }

    void printPetalCount(){
//!        this(11);   // NOt inside non-constructor
        print("petalCount = " + petalCount + " s = " + s);
    }
    public static void main(String[] args) {
        Flower x = new Flower();
        x.printPetalCount();

    }
}
