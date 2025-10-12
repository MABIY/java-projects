package adapter.twoway.adapter;

import adapter.twoway.duck.Duck;
import adapter.twoway.turkey.Turkey;

import java.util.Random;

/**
 * @author lh
 */
public class DuckTurkeyTwoWayAdapter implements Duck, Turkey {
    private Duck duck;

    private Turkey turkey;
    private Random random;

    public DuckTurkeyTwoWayAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    public DuckTurkeyTwoWayAdapter(Duck duck) {
        this.duck = duck;
        random = new Random();
    }

    @Override
    public void quack() {
        if(turkey !=null){
            turkey.gobble();
        }else {
            duck.quack();
        }
    }

    @Override
    public void gobble() {
        duck.quack();
    }

    @Override
    public void fly() {
        if(turkey !=null){
            for(int i = 0; i < 5; i++) {
                turkey.fly();
            }
        } else {
            if(random.nextInt(5)==0){
                duck.fly();
            }
        }
    }
}
