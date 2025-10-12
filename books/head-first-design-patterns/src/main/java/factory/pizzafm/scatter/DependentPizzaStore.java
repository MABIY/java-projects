package factory.pizzafm.scatter;

import factory.pizzafm.Pizza;
import factory.pizzafm.store.impl.chicago.products.ChicagoStyleCheesePizza;
import factory.pizzafm.store.impl.chicago.products.ChicagoStyleClamPizza;
import factory.pizzafm.store.impl.chicago.products.ChicagoStylePepperoniPizza;
import factory.pizzafm.store.impl.chicago.products.ChicagoStyleVeggiePizza;
import factory.pizzafm.store.impl.ny.products.NYStyleCheesePizza;
import factory.pizzafm.store.impl.ny.products.NYStyleClamPizza;
import factory.pizzafm.store.impl.ny.products.NYStylePepperoniPizza;
import factory.pizzafm.store.impl.ny.products.NYStyleVeggiePizza;

/**
 * @author lh
 */
public class DependentPizzaStore {
    public Pizza createPizza(String style, String type) {
        Pizza pizza = null;
        if (style.equals("Ny")) {

            if (type.equals("cheese")) {
                pizza = new NYStyleCheesePizza();
            } else if (type.equals("veggie")) {
                pizza = new NYStyleVeggiePizza();
            } else if (type.equals("clam")) {
                pizza = new NYStyleClamPizza();
            } else if (type.equals("pepperoni")) {
                pizza = new NYStylePepperoniPizza();
            }

        } else if (style.equals("Chicago")) {
            if (type.equals("cheese")) {
                pizza = new ChicagoStyleCheesePizza();
            } else if (type.equals("veggie")) {
                pizza = new ChicagoStyleVeggiePizza();
            } else if (type.equals("clam")) {
                pizza = new ChicagoStyleClamPizza();
            } else if (type.equals("pepperoni")) {
                pizza = new ChicagoStylePepperoniPizza();
            }
        } else {
            System.out.println("Error: invalid type of pizza");
            return null;
        }

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
