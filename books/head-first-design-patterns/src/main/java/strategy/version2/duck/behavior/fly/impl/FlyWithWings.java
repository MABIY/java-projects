package strategy.version2.duck.behavior.fly.impl;

import strategy.version2.duck.behavior.fly.FlyBehavior;

/**
 * @author lh
 */
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying");
    }
}
