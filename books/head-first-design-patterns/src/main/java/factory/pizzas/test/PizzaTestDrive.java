package factory.pizzas.test;

import factory.pizzas.Pizza;
import factory.pizzas.factory.SimplePizzaFactory;
import factory.pizzas.store.PizzaStore;

/**
 * @author lh
 */
public class PizzaTestDrive {
    public static void main(String[] args){
        SimplePizzaFactory factory = new SimplePizzaFactory();
        PizzaStore store = new PizzaStore(factory);

        Pizza pizza = store.orderPizza("cheese");
        System.out.println("We ordered a " + pizza.getName() + System.lineSeparator());
        System.out.println(pizza);

        pizza = store.orderPizza("veggie");
        System.out.println("We ordered a " + pizza.getName() + System.lineSeparator());
        System.out.println(pizza);
    }
}
