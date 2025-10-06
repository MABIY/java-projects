package strategy.version4.duck.impl;

import strategy.version4.duck.Duck;
import strategy.version4.fly.impl.FlyNoWay;
import strategy.version4.quack.impl.MuteQuack;

/**
 * @author lh
 */
public class DecoyDuck extends Duck {
    public DecoyDuck() {
        setFlyBehavior(new FlyNoWay());
        setQuackBehavior(new MuteQuack());
    }

    @Override
    public void display() {
        System.out.println("I'm a duck Decoy");
    }
}
