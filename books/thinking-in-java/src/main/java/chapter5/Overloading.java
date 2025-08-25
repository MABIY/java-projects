package chapter5;

import static net.mindview.util.Print.print;

/**
 * Demonstration of both constructor
 * and ordinary method overloading.
 * @author liu.hua
 */
class Tree3 {
    int height;
    Tree3() {
        print("Planting a seedling");
        height = 0;
    }
    Tree3(int initialHeight){
        height = initialHeight;
        print("Creating new Tree that is " +
                height + " feet tall");
    }

    void info(){
        print("Tree is " + height + " feet tall");
    }

    void info(String s){
        print(s + ": Tree is " + height + " feet tall");
    }
}

public class Overloading {
    private static Tree3 t;

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Tree3 t = new Tree3(i);
            t.info();
            t.info("Overloaded method");
        }
        // Overloaded constructor
        new Tree3();
    }
}
