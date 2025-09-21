package chapter8.practice.music7;

import chapter8.music.Note;

import static net.mindview.util.Print.print;

/**
 * Add a new Instrument to Music3.java and verify that ploymorphism works for
 * your new type.
 * @author lh
 */
class Instrument {
    void play(Note n ){
        print("Instrument.play " + n);
    }

    @Override
    public String toString() {
        return "Instrument";
    }

    void adjust(){
        print("Adjusting Instrument");
    }
}

class Wind extends Instrument{
    @Override
    void play(Note n) {
        print("Wind.paly() " +n);
    }

    @Override
    public String toString() {
        return "Wind";
    }

    @Override
    void adjust() {
        print("Adjusting Wind");
    }
}

class Percussion extends Instrument{
    @Override
    void play(Note n) {
        print("Percussion.play() " + n);
    }


    @Override
    public String toString() {
        return "Percussion";
    }

    @Override
    void adjust() {
        print("Adjusting Percussion");
    }
}

class Stringed extends Instrument{
    @Override
    void play(Note n) {
        print("Stringed.play() "  + n);
    }

    @Override
    public String toString() {
        return "Stringed";
    }

    @Override
    void adjust() {
        print("Adjusting Stringed");
    }
}
class Keyboard extends Instrument{
    @Override
    void play(Note n) {
        print("Keyboard.play() " +n);
    }

    @Override
    public String toString() {
        return "keyboard";
    }

    @Override
    void adjust() {
        print("Adjusting Keyboard");
    }
}

class Brass extends Wind {
    @Override
    void play(Note n) { print("Brass.play() " + n); }
    public String toString() { return "Brass"; }
    void adjust() { print("Adjusting Brass"); }
}

class Woodwind extends Wind {
    void play(Note n) { print("Woodwind.play() " + n); }

    @Override
    void adjust() {
        super.adjust();
    }

    public String toString() { return "Woodwind"; }
}

class Piano extends Keyboard {
    void play(Note n) { print("Piano.play() " + n); }
    public String toString() { return "Piano"; }
}
public class Shapes_p08_07 {
  //Doesn't care about type, so new types
    // added to the system still work right:
    public static void tune(Instrument i){
        i.play(Note.MIDDLE_C);
    }

    public static void tuneAll(Instrument[] e){
        for (Instrument i : e) {
            tune(i);
        }
    }

    public static void main(String[] args){
        // Upcasting during addition to the array:
        Instrument[] orchestra = {
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new Woodwind(),
                new Piano()
        };

        tuneAll(orchestra);
        for (Instrument i : orchestra) {
            System.out.println(i);
        }
    }
}
