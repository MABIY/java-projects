package adapter.oneway.adapter;

import adapter.oneway.duck.Duck;
import adapter.oneway.turkey.Turkey;

import java.util.Random;

/**
 * @author lh
 */
public class DuckToTurkeyAdapter implements Turkey {
    private Random random;

    public DuckToTurkeyAdapter(Duck duck) {
        this.duck = duck;
    }

    private Duck duck;

    @Override
    public void gobble() {
        duck.quack();
        random = new Random();
    }

    @Override
    public void fly() {
        if(random.nextInt(5)==0){
            duck.fly();
        }

    }
}
