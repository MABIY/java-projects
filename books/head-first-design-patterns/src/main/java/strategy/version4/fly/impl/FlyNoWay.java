package strategy.version4.fly.impl;

import strategy.version4.fly.FlyBehavior;

/**
 * @author lh
 */
public class FlyNoWay implements FlyBehavior {
	public void fly() {
		System.out.println("I can't fly");
	}
}
