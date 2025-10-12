package adapter.test;

import adapter.ducks.Duck;
import adapter.ducks.impl.MallardDuck;
import adapter.turkeys.Turkey;
import adapter.adapter.TurkeyToDuckAdapter;
import adapter.turkeys.impl.WildTurkey;

/**
 * @author lh
 */
public class DuckTestDrive {
    public static void main(String[] args){
        Duck duck = new MallardDuck();
        Turkey turkey = new WildTurkey();

        Duck turkeyAdapter =  new TurkeyToDuckAdapter(turkey);

        System.out.println("The Turkey says...");
        turkey.gobble();
        turkey.fly();

        System.out.println(System.lineSeparator() +"The Duck says...");
        testDuck(duck);

        System.out.println(System.lineSeparator() +"The TurkeyToDuckAdapter says...");
        testDuck(turkeyAdapter);
    }

    static void testDuck(Duck duck){
        duck.quack();
        duck.fly();
    }
}
