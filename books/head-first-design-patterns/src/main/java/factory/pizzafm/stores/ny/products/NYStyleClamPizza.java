package factory.pizzafm.stores.ny.products;

import factory.pizzafm.Pizza;

/**
 * @author lh
 */
public class NYStyleClamPizza extends Pizza {
    public NYStyleClamPizza() {
        name = "NY Style Clam Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";

        toppings.add("Crated Reggiano Cheese");
        toppings.add("Fresh Clams from Long Island Sound");
    }
}
