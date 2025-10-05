package strategy.version1.duck.impl;

import strategy.version1.duck.Duck;
import strategy.version1.duck.behavior.fly.FlyBehavior;
import strategy.version1.duck.behavior.fly.impl.FlyNoWay;
import strategy.version1.duck.behavior.quack.QuackBehavior;
import strategy.version1.duck.behavior.quack.impl.Quack;

/**
 * @author lh
 */
public class ModelDuck extends Duck {
    public ModelDuck() {
        super(new FlyNoWay(), new Quack());
    }

    @Override
    public void display() {
        System.out.println("I'm a model duck");
    }
}
