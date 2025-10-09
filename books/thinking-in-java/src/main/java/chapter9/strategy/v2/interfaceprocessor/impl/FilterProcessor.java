package chapter9.strategy.v2.interfaceprocessor.impl;

import chapter9.strategy.v2.filters.*;
import chapter9.strategy.v2.interfaceprocessor.Apply;
import chapter9.strategy.v2.interfaceprocessor.Processor;

/**
 * @author lh
 */
class FilterAdapter implements Processor {
    private Filter filter;

    public FilterAdapter(Filter filter) {
        this.filter = filter;
    }

    @Override
    public String name() {
        return filter.name();
    }

    @Override
    public Object process(Object input) {
        return filter.process((Waveform) input);
    }
}
public class FilterProcessor {
    public static void main(String[] args){
        Waveform waveform = new Waveform();
        Apply.process(new FilterAdapter(new LowPass(1.0)),waveform);
        Apply.process(new FilterAdapter(new HighPass(1.0)), waveform);
        Apply.process(new FilterAdapter(new BandPass(3.0,4.0)), waveform);
    }
}
