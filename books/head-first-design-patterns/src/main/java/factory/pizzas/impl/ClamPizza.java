package factory.pizzas.impl;

import factory.pizzas.Pizza;

/**
 * @author lh
 */
public class ClamPizza extends Pizza {
    public ClamPizza(){
        name ="Clam Pizza";
        dough = "Thin crust";
        sauce = "White garlic sauce";
        toppings.add("Clams");
        toppings.add("Grated parmesan cheese");
    }
}
