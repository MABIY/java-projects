package chapter8.music;
/**
 * Inheritance & upcasting.
 * @author lh
 */
public class Music {
    public static void main(String[] args){
        Wind flute  = new Wind();
        tune(flute);
    }

    private static void tune(Wind flute) {
        flute.play(Note.MIDDLE_C);
    }
}
