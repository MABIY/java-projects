package chapter7;
class Instrument{
    static void tune(Instrument i){
        i.play();
    }

    public void play(){}

}

/**
 * Wind objects are instruments
 * because they have the same interface:
 * @author lh
 */
public class Wind extends Instrument{
    public static void main(String[] args){
        Wind flute =  new Wind();
        //Upcasting
        Instrument.tune(flute);
    }
}
