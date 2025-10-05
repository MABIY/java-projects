package strategy.version2.duck.impl;

import strategy.version2.duck.Duck;
import strategy.version2.duck.behavior.fly.FlyBehavior;
import strategy.version2.duck.behavior.fly.impl.FlyNoWay;
import strategy.version2.duck.behavior.quack.QuackBehavior;
import strategy.version2.duck.behavior.quack.impl.Quack;

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
