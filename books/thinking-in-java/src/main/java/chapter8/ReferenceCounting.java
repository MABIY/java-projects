package chapter8;

import static net.mindview.util.Print.print;

/**
 * Cleaning up shared member objects
 * @author lh
 */
class Shared{
    private static long counter = 0;
    private final long id = counter++;
    private int refcount = 0;

    public Shared() {
        print("Creating " + this);
    }
    public void addRef(){
        refcount++;
    }

    protected void dispose(){
        if(--refcount ==0){
            print("Disposing " + this);
        }
    }

    @Override
    public String toString() {
        return "Shared" + id;
    }
}

class Composing {
    private Shared shared;
    private static long counter =0;
    private final long id = counter++;

    public Composing(Shared shared) {
        this.shared = shared;
        print("Creating " + this);
        this.shared = shared;
        this.shared.addRef();
    }

    protected void dispose(){
        print("disposing " + this);
        shared.dispose();
    }

    @Override
    public String toString() {
        return "Composing " + id;
    }
}
public class ReferenceCounting {
    public static void main(String[] args) throws InterruptedException {
        Shared shared = new Shared();
        Composing[] composings = {
                new Composing(shared),
                new Composing(shared),
                new Composing(shared),
                new Composing(shared),
                new Composing(shared),
        };
        for (Composing c : composings) {
            c.dispose();
        }
    }
}
