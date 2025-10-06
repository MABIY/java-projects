package strategy.version4.duck.impl;

import strategy.version4.duck.Duck;
import strategy.version4.fly.FlyBehavior;
import strategy.version4.fly.impl.FlyNoWay;
import strategy.version4.quack.QuackBehavior;

/**
 * @author lh
 */
public class RubberDuck extends Duck {
    public RubberDuck() {
        flyBehavior = new FlyNoWay();
        //        quackBehavior = new Squeak();
        quackBehavior = () -> System.out.println("Squeak");
    }

    public RubberDuck(FlyBehavior flyBehavior, QuackBehavior quackBehavior){
        this.flyBehavior = flyBehavior;
        this.quackBehavior = quackBehavior;
    }

    @Override
    public void display() {
        System.out.println("I'm a rubber duckie");
    }
}
