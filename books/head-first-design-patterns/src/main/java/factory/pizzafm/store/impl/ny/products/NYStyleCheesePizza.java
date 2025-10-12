package factory.pizzafm.store.impl.ny.products;

import factory.pizzafm.Pizza;

/**
 * @author lh
 */
public class NYStyleCheesePizza extends Pizza {
    public NYStyleCheesePizza() {
        name ="NY Style sauce and Cheese Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";

        toppings.add("Crated Reggiano Cheese");
    }
}
