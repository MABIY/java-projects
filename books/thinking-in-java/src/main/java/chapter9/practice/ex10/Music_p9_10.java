package chapter9.practice.ex10;


import chapter9.practice.Note;

import static net.mindview.util.Print.print;

/**
 * Modify  Music5.java by adding a playable interface. Move the play() declaration
 * form Instrument to Playable. Add Playable to hte derived classes by including
 * it in the implement list. Change tune() so that it takes a Playable instead of and
 * Instrument.
 * @author lh
 */
interface Instrument{
    //compile-time constant:
    //static and final
    int VALUE =5;
    // Cannot have method definitions:
    void adjust();
}
interface Playable{
    void play(Note nt); // Automatically public
}

class Wind implements Instrument, Playable{
    @Override
    public void play(Note n) {
        print(this + ".play() " + n);
    }

    @Override
    public String toString() {
        return "Wind";
    }

    public void adjust(){
        print(this + ".adjust()");
    }
}

class Percussion implements Instrument, Playable{
    @Override
    public void play(Note n) {
        print(this +".play() " + n);
    }

    @Override
    public String toString() {
        return "Percussion";
    }

    public void adjust(){
        print(this + ".adjust()");
    }
}
class Stringed implements Instrument,Playable{
    @Override
    public void play(Note n) {
        print(this + ".play() " + n);
    }

    @Override
    public String toString() {
        return "Stringed";
    }

    @Override
    public void adjust() {
        print(this + ".adjust()");
    }
}

class Brass extends Wind {
    @Override
    public String toString() {
        return "Brass";
    }
}

class Woodwind extends Wind{
    @Override
    public String toString() {
        return "Woodwing";
    }
}
public class Music_p9_10 {
    // Doesn't care about type , so new types
    // added to the system will work right:
    static void tune(Playable p){
        p.play(Note.MIDDLE_C);
    }

    static void tuneAll(Playable[] e){
        for (Playable p : e) {
            tune(p);
        }
    }
    public static void main(String[] args){
        // Upcasting during addition to the array:
        Playable[] orchestra = {new Wind(), new Percussion(), new Stringed(), new Brass(), new Woodwind()};
        tuneAll(orchestra);
    }
}

