package strategy.version2.duck.behavior.fly.impl;

import strategy.version2.duck.behavior.fly.FlyBehavior;

/**
 * @author lh
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can't fly");
    }
}
