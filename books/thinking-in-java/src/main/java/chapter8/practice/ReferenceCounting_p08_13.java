package chapter8.practice;

import static net.mindview.util.Print.print;

/**
 * Add a finalize() method to ReferenceCounting.java to verify the termination
 * condition (see the Initialization & Cleanup chapter).
 * @author lh
 */

class Shared{
    private int refcount =0;
    private static long counter = 0;
    private final long id = counter++;
    public Shared(){
        print("Creating " + this);
    }
    public void addRef(){
        refcount++;
    }

    @Override
    protected void finalize() {
        if(refcount>0){
            print("Error:" + refcount + " Shared " + id +" objects is use");

        }
    }
    protected void dispose(){
        if(--refcount ==0){
            print("Disposing " + this);
        }
    }

    @Override
    public String toString() {
        return "Shared " + id;
    }
}

class Composing {
    private Shared shared;
    private static long counter =0;
    private final long id = counter++;

    public Composing(Shared shared) {
        print("Crating " + this);
        this.shared = shared;
        this.shared.addRef();
    }
    protected void dispose(){
        print("Disposing " + this);
        shared.dispose();
    }

    @Override
    public String toString() {
        return "Composing " + id;
    }
}
public class ReferenceCounting_p08_13 {
    public static void main(String[] args){
        Shared shared = new Shared();
        Composing[] composings ={
                new Composing(shared),
                new Composing(shared),
                new Composing(shared),
                new Composing(shared),
                new Composing(shared),
        };
        for (Composing c : composings) {
            c.dispose();
        }
        Composing compTest = new Composing(shared);
        Composing compTest2 = new Composing(shared);
        shared.finalize();
        Shared sharedTest = new Shared();
        Composing compTest3 = new Composing(sharedTest);
        sharedTest.finalize();

    }
}
