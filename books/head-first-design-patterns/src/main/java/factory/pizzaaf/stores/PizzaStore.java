package factory.pizzaaf.stores;

import factory.pizzaaf.Pizza;

/**
 * @author lh
 */
public abstract class PizzaStore {
    protected abstract Pizza cretePizza(String type);

    public final Pizza orderPizza(String type){
        Pizza pizza =cretePizza(type);
        System.out.println("--- Making a " + pizza.getName() + " ---");

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
