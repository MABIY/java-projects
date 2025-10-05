package strategy.version3.fly.impl;

import strategy.version3.fly.FlyBehavior;

/**
 * @author lh
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can't fly");
    }
}
