package factory.pizzaaf.impl;

import factory.pizzaaf.Pizza;
import factory.pizzaaf.factory.ingredientfactory.PIzzaIngredientFactory;

/**
 * @author lh
 */
public class PepperoniPizza extends Pizza {
    public PepperoniPizza(PIzzaIngredientFactory pIzzaIngredientFactory) {
        super(pIzzaIngredientFactory);
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " +name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        veggies = ingredientFactory.createVeggies();
        pepperoni = ingredientFactory.createPepperoni();

    }
}
