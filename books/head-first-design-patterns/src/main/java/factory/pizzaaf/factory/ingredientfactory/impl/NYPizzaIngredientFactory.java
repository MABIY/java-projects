package factory.pizzaaf.factory.ingredientfactory.impl;

import factory.pizzaaf.ingredients.cheese.Cheese;
import factory.pizzaaf.ingredients.cheese.impl.ReggianoCheese;
import factory.pizzaaf.ingredients.clam.Clam;
import factory.pizzaaf.ingredients.clam.impl.FreshClam;
import factory.pizzaaf.ingredients.dough.Dough;
import factory.pizzaaf.ingredients.dough.impl.ThinCrustDough;
import factory.pizzaaf.factory.ingredientfactory.PIzzaIngredientFactory;
import factory.pizzaaf.ingredients.pepperoni.Pepperoni;
import factory.pizzaaf.ingredients.pepperoni.impl.SlicedPepperoni;
import factory.pizzaaf.ingredients.sauce.Sauce;
import factory.pizzaaf.ingredients.sauce.impl.MarinaraSauce;
import factory.pizzaaf.ingredients.veggie.Veggie;
import factory.pizzaaf.ingredients.veggie.impl.Garlic;
import factory.pizzaaf.ingredients.veggie.impl.Mushroom;
import factory.pizzaaf.ingredients.veggie.impl.Onion;
import factory.pizzaaf.ingredients.veggie.impl.RedPepper;

/**
 * @author lh
 */
public class NYPizzaIngredientFactory implements PIzzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Veggie[] createVeggies() {
        Veggie[] veggies = {
                new Garlic(),
                new Onion(),
                new Mushroom(),
                new RedPepper(),

        };
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clam creatClam() {
        return new FreshClam();
    }

}
