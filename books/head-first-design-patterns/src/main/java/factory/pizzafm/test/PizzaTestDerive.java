package factory.pizzafm.test;

import factory.pizzafm.Pizza;
import factory.pizzafm.stores.PizzaStore;
import factory.pizzafm.stores.chicago.ChicagoPizzaStore;
import factory.pizzafm.stores.ny.NYPizzaStore;

/**
 * @author lh
 */
public class PizzaTestDerive {
    public static void main(String[] args){
        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + pizza.getName() + System.lineSeparator());

        pizza = chicagoStore.orderPizza("cheese");
        System.out.println("Joel ordered a " + pizza.getName() + System.lineSeparator());

        pizza = nyStore.orderPizza("clam");
        System.out.println("Ethan ordered a " + pizza.getName() + System.lineSeparator());

        pizza = chicagoStore.orderPizza("clam");
        System.out.println("Joel ordered a " + pizza.getName() + System.lineSeparator());

        pizza = nyStore.orderPizza("pepperoni");
        System.out.println("Ethan ordered a " + pizza.getName() + System.lineSeparator());

        pizza = chicagoStore.orderPizza("pepperoni");
        System.out.println("Joel ordered a " + pizza.getName() + System.lineSeparator());

        pizza = nyStore.orderPizza("veggie");
        System.out.println("Ethan ordered a " + pizza.getName() + System.lineSeparator());

        pizza = chicagoStore.orderPizza("veggie");
        System.out.println("Joel ordered a " + pizza.getName() + System.lineSeparator());
    }
}
