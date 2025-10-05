package strategy.version1.duck.behavior.fly.impl;

import strategy.version1.duck.behavior.fly.FlyBehavior;

/**
 * @author lh
 */
public class FlyRocketPowered implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying with a rocket");
    }
}
