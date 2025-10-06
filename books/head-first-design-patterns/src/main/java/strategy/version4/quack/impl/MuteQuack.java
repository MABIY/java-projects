package strategy.version4.quack.impl;

import strategy.version4.quack.QuackBehavior;

public class MuteQuack implements QuackBehavior {
	public void quack() {
		System.out.println("<< Silence >>");
	}
}
