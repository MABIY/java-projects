package strategy.version3.duck.impl;

import strategy.version3.duck.Duck;
import strategy.version3.fly.impl.FlyWithWings;
import strategy.version3.fly.marker.CanFly;
import strategy.version3.quack.impl.Quack;
import strategy.version3.quack.marker.CanQuack;

/**
 * @author lh
 */
public class MallardDuck extends Duck implements CanFly, CanQuack {
    public MallardDuck() {
        super(new FlyWithWings(),new Quack());
    }

    @Override
    public void display() {
        System.out.println("I'm a real Mallard duck");
    }
}
