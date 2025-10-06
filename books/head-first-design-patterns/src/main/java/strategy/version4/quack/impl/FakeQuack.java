package strategy.version4.quack.impl;

import strategy.version4.quack.QuackBehavior;

public class FakeQuack implements QuackBehavior {
	public void quack() {
		System.out.println("Qwak");
	}
}
