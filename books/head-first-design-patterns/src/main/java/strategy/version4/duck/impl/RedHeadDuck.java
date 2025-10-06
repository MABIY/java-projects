package strategy.version4.duck.impl;

import strategy.version4.duck.Duck;
import strategy.version4.fly.impl.FlyWithWings;
import strategy.version4.quack.impl.Quack;

/**
 * @author lh
 */
public class RedHeadDuck extends Duck {
    public RedHeadDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a real Red Headed duck");

    }
}
