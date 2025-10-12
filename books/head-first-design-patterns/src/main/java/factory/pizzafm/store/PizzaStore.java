package factory.pizzafm.store;


import factory.pizzafm.Pizza;

/**
 * @author lh
 */
public abstract class PizzaStore {
    protected abstract Pizza createPizza(String type);

    public final Pizza orderPizza(String type){
        Pizza pizza = createPizza(type);
        System.out.println("--- Making a " + pizza.getName() + " ---");

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
