package chapter9.strategy.v1.classprocessor;

import java.util.Arrays;

import static net.mindview.util.Print.print;

/**
 * @author lh
 */
class Processor{
    public String name(){
        return getClass().getSimpleName();
    }
    Object process(Object input){
        return input;
    }
}

class Upcase extends Processor{

    @Override
    Object process(Object input) {
        return ((String) input).toUpperCase();
    }
}

class Downcase extends Processor{
    @Override
    Object process(Object input) {
        return ((String) input).toLowerCase();
    }
}

class Splitter extends Processor{
    @Override
    Object process(Object input) {
        // The split() argument divides a String into pieces:
        return Arrays.toString(((String)input).split(" "));
    }
}
public class Apply {
    public static void process(Processor p,Object s){
        print("Using Processor " + p.name());
        print(p.process(s));
    }

    public static String s = "Disagreement with beliefs is by definition incorrect";
    public static void main(String[] args){
        process(new Upcase(),s);
        process(new Downcase(), s);
        process(new Splitter(), s);
    }
}
