package adapter.twoway.test;

import adapter.twoway.adapter.DuckTurkeyTwoWayAdapter;
import adapter.twoway.duck.Duck;
import adapter.twoway.duck.impl.MallardDuck;
import adapter.twoway.turkey.Turkey;
import adapter.twoway.turkey.impl.WildTurkey;

/**
 * @author lh
 */
public class DuckTurkeyTestDrive {
    public static void main(String[] args){
        Duck duck = new MallardDuck();
        Turkey turkey = new WildTurkey();

        DuckTurkeyTwoWayAdapter turkeyToDuck = new DuckTurkeyTwoWayAdapter(turkey);
        DuckTurkeyTwoWayAdapter duckToTurkey = new DuckTurkeyTwoWayAdapter(duck);

        System.out.println("The Turkey says...");
        testTurkey(turkey);
        System.out.println("The duckToTurkeyTwoWayAdapter says...");
        testTurkey(duckToTurkey);

        System.out.println("The Duck says...");
        testDuck(duck);
        System.out.println("The turkeyToDuckTwoWayAdapter says...");
        testDuck(turkeyToDuck);
    }

    static void testDuck(Duck duck){
        duck.quack();
        duck.fly();
    }

    static void testTurkey(Turkey turkey){
        turkey.gobble();
        turkey.fly();
    }
}
