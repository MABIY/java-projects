package chapter8.music;
/**
 * Wind object are instruments
 * because they have the same interface
 * @author lh
 */
public class Wind extends Instrument {
    //Redefine interface method:

    @Override
    public void play(Note n) {
        System.out.println("Wind.play() " + n);
    }
}
