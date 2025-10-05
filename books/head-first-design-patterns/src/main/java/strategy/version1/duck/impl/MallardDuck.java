package strategy.version1.duck.impl;

import strategy.version1.duck.Duck;
import strategy.version1.duck.behavior.fly.impl.FlyWithWings;
import strategy.version1.duck.behavior.quack.impl.Quack;

/**
 * @author lh
 */
public class MallardDuck extends Duck {
    public MallardDuck() {
        super(new FlyWithWings(),new Quack());
    }

    @Override
    public void display() {
        System.out.println("I'm a real Mallard duck");
    }
}
