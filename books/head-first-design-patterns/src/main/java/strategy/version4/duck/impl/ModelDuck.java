package strategy.version4.duck.impl;

import strategy.version4.duck.Duck;
import strategy.version4.fly.impl.FlyNoWay;
import strategy.version4.quack.impl.Quack;

/**
 * @author lh
 */
public class ModelDuck extends Duck {
    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a model duck");

    }
}
