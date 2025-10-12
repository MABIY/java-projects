package adapter.oneway.duck.impl;

import adapter.oneway.duck.Duck;

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
