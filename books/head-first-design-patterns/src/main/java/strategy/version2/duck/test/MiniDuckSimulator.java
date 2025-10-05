package strategy.version2.duck.test;

import strategy.version2.duck.Duck;
import strategy.version2.duck.behavior.fly.impl.FlyRocketPowered;
import strategy.version2.duck.impl.MallardDuck;
import strategy.version2.duck.impl.ModelDuck;

/**
 * @author lh
 */
public class MiniDuckSimulator {
    public static void main(String[] args){
        Duck mallard = new MallardDuck();
        mallard.fly();
        mallard.quack();

        Duck model = new ModelDuck();
        model.fly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.fly();
    }
}
