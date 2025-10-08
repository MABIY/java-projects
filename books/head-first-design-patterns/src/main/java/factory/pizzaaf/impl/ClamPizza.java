package factory.pizzaaf.impl;

import factory.pizzaaf.Pizza;
import factory.pizzaaf.factories.ingredientfactory.PIzzaIngredientFactory;

/**
 * @author lh
 */
public class ClamPizza extends Pizza {
    public ClamPizza(PIzzaIngredientFactory pIzzaIngredientFactory) {
        super(pIzzaIngredientFactory);
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " +name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        clam = ingredientFactory.creatClam();
    }
}
