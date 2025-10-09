package chapter9.strategy.v2.filters;

/**
 * @author lh
 */
public class Filter {
    public String name(){
        return getClass().getSimpleName();
    }

    public Waveform process(Waveform input){
        return input;
    }
}

