package strategy.version3.duck;


import strategy.version3.fly.FlyBehavior;
import strategy.version3.quack.QuackBehavior;

/**
 * 使用 **marker interface** 来标识是否可飞，同时暴露策略模式的 算法的变化独立与使用算法的客户
 * @author lh
 */
public abstract class Duck {
    protected FlyBehavior flyBehavior;
    protected QuackBehavior quackBehavior;

    //todo_lh 如果很多参数，需要在创建对象的时候初始化，该如何结果
    public Duck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        this.flyBehavior = flyBehavior;
        this.quackBehavior = quackBehavior;
    }

    public abstract void display();


    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public void performFly(){
        flyBehavior.fly();
    }
    public void performQuack(){
        quackBehavior.quack();
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void swim(){
        System.out.println("All duck float, even decoys!");
    }
}
