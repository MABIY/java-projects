package factory.pizzafm.store.impl.ny;

import factory.pizzafm.Pizza;
import factory.pizzafm.store.PizzaStore;
import factory.pizzafm.store.impl.ny.products.NYStyleCheesePizza;
import factory.pizzafm.store.impl.ny.products.NYStyleClamPizza;
import factory.pizzafm.store.impl.ny.products.NYStylePepperoniPizza;
import factory.pizzafm.store.impl.ny.products.NYStyleVeggiePizza;

/**
 * @author lh
 */
public class NYPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        if(type.equals("cheese")){
            return new NYStyleCheesePizza();
        }else if(type.equals("veggie")){
            return new NYStyleVeggiePizza();
        }else if(type.equals("clam")){
            return new NYStyleClamPizza();
        }else if(type.equals("pepperoni")){
            return new NYStylePepperoniPizza();
        } else {
            return null;
        }

    }

}
