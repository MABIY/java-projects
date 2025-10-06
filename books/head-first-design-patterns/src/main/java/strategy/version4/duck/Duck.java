package strategy.version4.duck;

import strategy.version4.fly.FlyBehavior;
import strategy.version4.quack.QuackBehavior;

/**
 * @author lh
 */
public abstract class Duck {
  protected FlyBehavior flyBehavior;
    protected QuackBehavior quackBehavior;

    public Duck(){}


    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public abstract void display();

    public void performFly(){
        flyBehavior.fly();
    }

    public void performQuack(){
        quackBehavior.quack();
    }

    public void swim(){
        System.out.println("All ducks float, even decoys!");
    }
}

