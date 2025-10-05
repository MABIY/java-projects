package strategy.version3.fly.impl;

import strategy.version3.fly.FlyBehavior;

/**
 * @author lh
 */
public class FlyRocketPowered implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying with a rocket");
    }
}
