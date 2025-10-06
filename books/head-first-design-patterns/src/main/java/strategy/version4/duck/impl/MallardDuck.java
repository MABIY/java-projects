package strategy.version4.duck.impl;

import strategy.version4.duck.Duck;
import strategy.version4.fly.impl.FlyWithWings;
import strategy.version4.quack.impl.Quack;

/**
 * @author lh
 */
public class MallardDuck extends Duck {
    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("I'm a real Mallard duck");
    }


}
