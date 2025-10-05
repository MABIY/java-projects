package strategy.version2.duck.behavior.quack.impl;

import strategy.version2.duck.behavior.quack.QuackBehavior;

/**
 * @author lh
 */
public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("<< silence >>");
    }
}
