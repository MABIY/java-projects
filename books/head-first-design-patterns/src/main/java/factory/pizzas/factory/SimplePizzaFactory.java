package factory.pizzas.factory;

import factory.pizzas.Pizza;
import factory.pizzas.impl.CheesePizza;
import factory.pizzas.impl.ClamPizza;
import factory.pizzas.impl.PepperoniPizza;
import factory.pizzas.impl.VeggiePizza;

/**
 * @author lh
 */
public class SimplePizzaFactory {
    public Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new CheesePizza();
        } else if (type.equals("pepperoni")) {
            return new PepperoniPizza();
        } else if (type.equals("clam")) {
            return new ClamPizza();
        } else if (type.equals("veggie")) {
            return new VeggiePizza();
        }
        return null;
    }
}
