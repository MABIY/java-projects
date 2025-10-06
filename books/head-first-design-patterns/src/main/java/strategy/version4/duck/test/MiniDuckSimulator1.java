package strategy.version4.duck.test;

import strategy.version4.duck.Duck;
import strategy.version4.duck.impl.*;
import strategy.version4.fly.impl.FlyRocketPowered;

/**
 * @author lh
 */
public class MiniDuckSimulator1 {
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
