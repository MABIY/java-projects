package chapter9.strategy.v2.interfaceprocessor;

import static net.mindview.util.Print.print;

/**
 * @author lh
 */
public class Apply {
    public static void process(Processor p , Object s){
        print("Using processor " + p.name());
        print(p.process(s));
    }
}
