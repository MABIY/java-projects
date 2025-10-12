package adapter.ducks.impl;

import adapter.ducks.Duck;

/**
 * @author lh
 */
public class MallardDuck implements Duck {

    @Override
    public void quack() {
        System.out.println("Quack");

    }

    @Override
    public void fly() {
        System.out.println("I'm flying");
    }
}
