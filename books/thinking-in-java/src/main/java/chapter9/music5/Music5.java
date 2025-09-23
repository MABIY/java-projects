package chapter9.music5;


import static net.mindview.util.Print.print;

/**
 * Interfaces.
 * @author lh
 */

interface Instrument{
    // Compile-time constant:
    // status & final
    int VALUE = 5;

    //Cannot have method definitions:
    // Automatically public
    void play(Note n);
}

class Wind implements Instrument{
    @Override
    public void play(Note n) {
        print(this + ".play() " + n);
    }

    @Override
    public String toString() {
        return "Wind";
    }

    public void adjust() {
        print(this + ".adjust()");
    }
}

class Percussion implements Instrument{
    @Override
    public void play(Note n) {
        print(this + ".play() "  + n) ;
    }

    @Override
    public String toString() {
        return "Percussion";
    }

    public void adjust(){
        print(this + ".adjust()");
    }
}

class Stringed implements Instrument{
    @Override
    public void play(Note n) {
        print(this + ".play() " +n);
    }

    @Override
    public String toString() {
        return "Stringed";
    }
    public void adjust(){
        print(this + ".adjust()");
    }
}

class Brass extends Wind{
    @Override
    public String toString() {
        return "Brass";
    }
}

class Woodwind extends Wind{
    @Override
    public String toString() {
        return "Woodwind";
    }
}
/**
 * @author lh
 */
public class Music5 {
   // Doesn't care about type, so new types
    // added to the system still work right:
    static void tune(Instrument i){
        //...
        i.play(Note.MIDDLE_C);
    }

    static void tuneAll(Instrument[] e){
        for (Instrument i : e) {
            tune(i);
        }
    }
    public static void main(String[] args){
        // Upcasting during additon to the array:
        Instrument[] orche3stra = {
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new Woodwind()
        };
        tuneAll(orche3stra);
    }
}
