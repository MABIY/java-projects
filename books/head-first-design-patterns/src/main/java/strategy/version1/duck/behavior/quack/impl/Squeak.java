package strategy.version1.duck.behavior.quack.impl;

import strategy.version1.duck.behavior.quack.QuackBehavior;

/**
 * @author lh
 */
public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Squeak");
    }
}
