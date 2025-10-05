package strategy.version3.duck.test;

import strategy.version3.duck.Duck;
import strategy.version3.duck.impl.MallardDuck;
import strategy.version3.duck.impl.ModelDuck;
import strategy.version3.fly.impl.FlyRocketPowered;
import strategy.version3.fly.marker.CanFly;
import strategy.version3.quack.marker.CanQuack;

/**
 * @author lh
 */
public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();
        System.out.println(
                "mallard: can fly: " + (mallard instanceof CanFly) + ", can quack:" + (mallard instanceof CanQuack));

        //<editor-fold desc="marker 无法动态的改变!!">
        Duck model = new ModelDuck();
        model.performFly();
        System.out.println("change model fly before, madel: can fly: " + (model instanceof CanFly) + ", can quack:"
                + (model instanceof CanQuack));
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
        System.out.println("changed model fly to FlyRocketPowered later, madel: can fly: " + (model instanceof CanFly)
                + ", can quack:" + (model instanceof CanQuack));
        //</editor-fold>
    }
}
