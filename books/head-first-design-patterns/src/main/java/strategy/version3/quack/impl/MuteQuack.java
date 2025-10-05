package strategy.version3.quack.impl;

import strategy.version3.quack.QuackBehavior;

/**
 * @author lh
 */
public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("<< silence >>");
    }
}
