package factory.pizzaaf.impl;

import factory.pizzaaf.Pizza;
import factory.pizzaaf.factory.ingredientfactory.PIzzaIngredientFactory;

/**
 * @author lh
 */
public class CheesePizza extends Pizza {
    public CheesePizza(PIzzaIngredientFactory pIzzaIngredientFactory) {
        super(pIzzaIngredientFactory);
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " +name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
    }
}
