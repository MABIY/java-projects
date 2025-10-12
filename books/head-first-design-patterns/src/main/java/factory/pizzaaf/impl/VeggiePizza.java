package factory.pizzaaf.impl;

import factory.pizzaaf.Pizza;
import factory.pizzaaf.factory.ingredientfactory.PIzzaIngredientFactory;

/**
 * @author lh
 */
public class VeggiePizza extends Pizza {
    public VeggiePizza(PIzzaIngredientFactory pIzzaIngredientFactory) {
        super(pIzzaIngredientFactory);
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " +name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        veggies = ingredientFactory.createVeggies();
    }
}
