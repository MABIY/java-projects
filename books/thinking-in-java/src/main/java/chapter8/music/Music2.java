package chapter8.music;

import static net.mindview.util.Print.print;

/**
 * Overloading instead of upcasting
 * @author lh
 */
class Stringed extends Instrument{
    @Override
    public void play(Note n) {
        print("Stringed.play()" + n);
    }
}

class Brass extends Instrument{
    @Override
    public void play(Note n) {
        print("Brass.play()" + n);
    }
}
/**
 * @author lh
 */
public class Music2 {
    public static void tune(Wind c){
        c.play(Note.MIDDLE_C);
    }
    public static void tune(Stringed c){
        c.play(Note.MIDDLE_C);
    }
    public static void tune(Brass c){
        c.play(Note.MIDDLE_C);
    }

    public static void main(String[] args){
        Wind flute = new Wind();
        Stringed violin = new Stringed();
        Brass frenchHorn = new Brass();
        //No upcasting
        tune(flute);
        tune(violin);
        tune(frenchHorn);
    }
}
