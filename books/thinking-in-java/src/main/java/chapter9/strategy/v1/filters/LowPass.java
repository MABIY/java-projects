package chapter9.strategy.v1.filters;
/**
 * @author lh
 */
public class LowPass extends Filter {
    double cutoff;

    public LowPass(double cutoff) {
        this.cutoff = cutoff;
    }

    @Override
    public Waveform process(Waveform input) {
        //Dummy processing
        return input;
    }
}
