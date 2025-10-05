package strategy.version3.duck.impl;

import strategy.version3.duck.Duck;
import strategy.version3.fly.impl.FlyNoWay;
import strategy.version3.quack.impl.Quack;
import strategy.version3.quack.marker.CanQuack;

/**
 * @author lh
 */
public class ModelDuck extends Duck implements CanQuack {
    public ModelDuck() {
        super(new FlyNoWay(), new Quack());
    }

    @Override
    public void display() {
        System.out.println("I'm a model duck");
    }
}
