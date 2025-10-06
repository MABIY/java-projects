package factory.pizzas.impl;

import factory.pizzas.Pizza;

/**
 * @author lh
 */
public class CheesePizza extends Pizza {
    public CheesePizza() {
        name ="Cheese Pizza";
        dough = "Regular Crust";
        sauce = "Marinara Pizza sauce";
        toppings.add("Fresh Mozzarella");
        toppings.add("Parmesan");
    }
}
