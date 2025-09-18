package chapter8.practice.music6;

import chapter8.music.Note;

import static net.mindview.util.Print.print;

/**
 * @author lh
 */
class Instrument{
    void play(Note n){
        print("Instrument.play()");
    }

    @Override
    public String toString() {
        return "Instrument";
    }

    void adjsut(){
        print("Adjusting Instrument");
    }
}

class Wind extends Instrument{
    @Override
    void play(Note n) {
        print("Wind.play()");
    }

    @Override
    public String toString() {
        return "Wind";
    }

    @Override
    void adjsut() {
        print("Adjusting Wind");
    }
}
class Percussion extends Instrument{
    @Override
    void play(Note n) {
        print("Percussion.play()");
    }

    @Override
    public String toString() {
        return "Percussion";
    }

    @Override
    void adjsut() {
        print("Adjusting Percussion");
    }
}
class Stringed extends Instrument{
    @Override
    void play(Note n) {
        print("Stringed.play()");
    }

    @Override
    public String toString() {
        return "Stringed";
    }

    @Override
    void adjsut() {
        print("Adjusting Stringed");
    }
}
class Brass extends Instrument{
    @Override
    void play(Note n) {
        print("Brass.play()");
    }

    @Override
    public String toString() {
        return "Brass";
    }

    @Override
    void adjsut() {
        print("Adjusting Brass");
    }
}
class WoodWind extends Instrument{
    @Override
    void play(Note n) {
        print("WoodWind.play()");
    }

    @Override
    public String toString() {
        return "WoodWind";
    }

    @Override
    void adjsut() {
        print("Adjusting WoodWind");
    }
}
public class Music_p08_06 {
    // Doesn't care about type, so new types
    // added to the system still work right:
    public static void tune(Instrument i){
        //...
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
            new Wind(), new Percussion(), new Stringed(), new Brass(), new WoodWind(),
        };
        tuneAll(orchestra);
        for (Instrument i : orchestra) {
            System.out.println(i);
        }
    }
}
