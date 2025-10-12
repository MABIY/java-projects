package adapter.oneway.adapter;

import adapter.oneway.duck.Duck;
import adapter.oneway.turkey.Turkey;

/**
 * @author lh
 */
public class TurkeyToDuckAdapter implements Duck {
    private Turkey turkey;

    public TurkeyToDuckAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        for(int i = 0; i < 5; i++) {
            turkey.fly();
        }
    }
}
