package chapter9.strategy.v2.interfaceprocessor.impl;


import chapter9.strategy.v2.interfaceprocessor.Apply;
import chapter9.strategy.v2.interfaceprocessor.Processor;

import java.util.Arrays;

/**
 * @author lh
 */
public abstract class StringProcessor implements Processor {
    public static String s = "if she weights the same as a duck, she's made of wood";

    public static void main(String[] args){
        Apply.process(new Upcase(),s);
        Apply.process(new Downcase(),s);
        Apply.process(new Spliter(), s);
    }

    @Override
    public String name(){
        return getClass().getSimpleName();
    }

    @Override
    public abstract String process(Object input);
}

class Upcase extends StringProcessor{
    @Override
    public String process(Object input) {
        return ((String)input).toUpperCase();
    }
}
class Downcase extends StringProcessor{
    @Override
    public String process(Object input) {
        return ((String)input).toLowerCase();
    }
}
class Spliter extends StringProcessor{
    @Override
    public String process(Object input) {
        return Arrays.toString(((String)input).split(" "));
    }
}
