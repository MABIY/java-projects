package factory.pizzafm.store.impl.chicago;

import factory.pizzafm.Pizza;
import factory.pizzafm.store.PizzaStore;
import factory.pizzafm.store.impl.chicago.products.ChicagoStyleCheesePizza;
import factory.pizzafm.store.impl.chicago.products.ChicagoStyleClamPizza;
import factory.pizzafm.store.impl.chicago.products.ChicagoStylePepperoniPizza;
import factory.pizzafm.store.impl.chicago.products.ChicagoStyleVeggiePizza;

/**
 * @author lh
 */
public class ChicagoPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new ChicagoStyleCheesePizza();
        } else if (type.equals("veggie")) {
            return new ChicagoStyleVeggiePizza();
        } else if (type.equals("clam")) {
            return new ChicagoStyleClamPizza();
        } else if (type.equals("pepperoni")) {
            return new ChicagoStylePepperoniPizza();
        } else {
            return null;
        }
    }
}
