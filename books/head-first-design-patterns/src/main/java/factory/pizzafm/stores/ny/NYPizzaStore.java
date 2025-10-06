package factory.pizzafm.stores.ny;

import factory.pizzafm.Pizza;
import factory.pizzafm.stores.PizzaStore;
import factory.pizzafm.stores.ny.products.NYStyleCheesePizza;
import factory.pizzafm.stores.ny.products.NYStyleClamPizza;
import factory.pizzafm.stores.ny.products.NYStylePepperoniPizza;
import factory.pizzafm.stores.ny.products.NYStyleVeggiePizza;

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
