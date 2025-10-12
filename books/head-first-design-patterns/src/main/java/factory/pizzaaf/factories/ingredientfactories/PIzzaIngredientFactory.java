package factory.pizzaaf.factories.ingredientfactories;

import factory.pizzaaf.ingredients.cheese.Cheese;
import factory.pizzaaf.ingredients.clam.Clam;
import factory.pizzaaf.ingredients.dough.Dough;
import factory.pizzaaf.ingredients.pepperoni.Pepperoni;
import factory.pizzaaf.ingredients.sauce.Sauce;
import factory.pizzaaf.ingredients.veggie.Veggie;

/**
 * @author lh
 */
public interface PIzzaIngredientFactory {
    Dough createDough();

    Sauce createSauce();

    Cheese createCheese();

    Veggie[] createVeggies();

    Pepperoni createPepperoni();

    Clam creatClam();
}
