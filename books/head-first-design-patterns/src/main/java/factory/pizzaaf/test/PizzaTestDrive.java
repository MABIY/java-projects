package factory.pizzaaf.test;

import factory.pizzaaf.Pizza;
import factory.pizzaaf.store.PizzaStore;
import factory.pizzaaf.store.impl.ChicagoPizzaStore;
import factory.pizzaaf.store.impl.NYPizzaStore;

/**
 * @author lh
 */
public class PizzaTestDrive {
    public static void main(String[] args){
        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + pizza + System.lineSeparator());

        pizza = chicagoStore.orderPizza("cheese");
        System.out.println("Joel ordered a " + pizza + System.lineSeparator());

        pizza = nyStore.orderPizza("clam");
        System.out.println("Ethan ordered a " + pizza + System.lineSeparator());

        pizza = chicagoStore.orderPizza("clam");
        System.out.println("Joel ordered a " + pizza + System.lineSeparator());

        pizza = nyStore.orderPizza("pepperoni");
        System.out.println("Ethan ordered a " + pizza + System.lineSeparator());

        pizza = chicagoStore.orderPizza("pepperoni");
        System.out.println("Joel ordered a " + pizza + System.lineSeparator());

        pizza = nyStore.orderPizza("veggie");
        System.out.println("Ethan ordered a " + pizza + System.lineSeparator());

        pizza = chicagoStore.orderPizza("veggie");
        System.out.println("Joel ordered a " + pizza + System.lineSeparator());
    }
}
