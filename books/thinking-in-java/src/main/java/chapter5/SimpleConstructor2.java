package chapter5;

import net.mindview.util.Print;

/**
 * @author liu.hua
 */
class Rock2 {
     Rock2(int i) {
        System.out.print("Rock " + i + " ");
    }
}

class Tree {
    int height =0 ;
    Tree(int height) {
        this.height = height;
        System.out.print("Three.height = " + height +" ");
    }
    Tree() {
    }
}
public class SimpleConstructor2 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Rock2(i);
        }
        for (int i = 0; i < 10; i++) {
            new Tree(i);
        }
    }

}
