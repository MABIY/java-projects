package strategy.version1.duck.test;

import strategy.version1.duck.Duck;
import strategy.version1.duck.behavior.fly.impl.FlyRocketPowered;
import strategy.version1.duck.impl.MallardDuck;
import strategy.version1.duck.impl.ModelDuck;

/**
 * @author lh
 */
public class MiniDuckSimulator {
public static void main(String[] args){
    Duck mallard = new MallardDuck();
    mallard.performQuack();
    mallard.performFly();


    Duck model = new ModelDuck();
    model.performFly();
    model.setFlyBehavior(new FlyRocketPowered());
    model.performFly();
}
}
