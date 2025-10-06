package strategy.version4.duck.test;

import strategy.version4.duck.Duck;
import strategy.version4.duck.impl.DecoyDuck;
import strategy.version4.duck.impl.MallardDuck;
import strategy.version4.duck.impl.ModelDuck;
import strategy.version4.duck.impl.RubberDuck;
import strategy.version4.fly.FlyBehavior;
import strategy.version4.fly.impl.FlyRocketPowered;
import strategy.version4.quack.QuackBehavior;

/**
 * @author lh
 */
public class MiniDuckSimulator {
    public static void main(String[] args){
        MallardDuck mallard = new MallardDuck();
        FlyBehavior cantFly = ()-> System.out.println("I can't fly");
        QuackBehavior squeak= ()-> System.out.println("Squeak");
        RubberDuck rubberDuckie = new RubberDuck(cantFly, squeak);
        DecoyDuck decoy = new DecoyDuck();

        Duck modle  = new ModelDuck();

        mallard.performQuack();
        rubberDuckie.performQuack();
        decoy.performQuack();

        modle.performFly();
        modle.setFlyBehavior(new FlyRocketPowered());
        modle.performFly();
    }
}
