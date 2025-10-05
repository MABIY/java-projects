package strategy.version2.duck;

import strategy.version2.duck.behavior.fly.FlyBehavior;
import strategy.version2.duck.behavior.fly.ProxyFlyBehavior;
import strategy.version2.duck.behavior.quack.ProxyQuackBehavior;
import strategy.version2.duck.behavior.quack.QuackBehavior;

/**
 * 缺点：
 *  - 语意上是实现了 Behavior 不过内部是通过其他实现类转发，语言不存，同时 ProxyBehavior是一个Behavior但实现类确实具体的Duck而不是单纯的转发，不好附庸。在使用时一定会被忽略是Duck（具体类来实现Duck）
 *  - 在行为族越來越多时，僵化帮死，需要 定义
 *     1.定义Proxy接口
 *     2.赋予实现类到组合字段
 *     3.方法准发调用
 *
 *     * 无法方便的在不需要类中移除方法（没有version1方便），同时，如果子类不需要某个行为，或只有某几个需要类结果体系会爆炸
 *     * 可以使用canFly 标记接口
 * @author lh
 */
public abstract class Duck implements ProxyFlyBehavior, ProxyQuackBehavior {
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

    @Override
    public void fly() {
        flyBehavior.fly();
    }

    @Override
    public void quack() {
        quackBehavior.quack();
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void swim(){
        System.out.println("All duck float, even decoys!");
    }
}
