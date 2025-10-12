package factory.pizzaaf.factory.ingredientfactory.impl;

import factory.pizzaaf.ingredients.cheese.Cheese;
import factory.pizzaaf.ingredients.cheese.impl.MozzarellaCheese;
import factory.pizzaaf.ingredients.clam.Clam;
import factory.pizzaaf.ingredients.clam.FrozenClam;
import factory.pizzaaf.ingredients.dough.Dough;
import factory.pizzaaf.ingredients.dough.impl.ThickCrustDough;
import factory.pizzaaf.factory.ingredientfactory.PIzzaIngredientFactory;
import factory.pizzaaf.ingredients.pepperoni.Pepperoni;
import factory.pizzaaf.ingredients.pepperoni.impl.SlicedPepperoni;
import factory.pizzaaf.ingredients.sauce.Sauce;
import factory.pizzaaf.ingredients.sauce.impl.PlumTomatoSauce;
import factory.pizzaaf.ingredients.veggie.Veggie;
import factory.pizzaaf.ingredients.veggie.impl.BlackOlive;
import factory.pizzaaf.ingredients.veggie.impl.Eggplant;
import factory.pizzaaf.ingredients.veggie.impl.Spinach;

/**
 * @author lh
 */
public class ChicagoPizzaIngredientFactory implements PIzzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }

    @Override
    public Cheese createCheese() {
        return new MozzarellaCheese();
    }

    @Override
    public Veggie[] createVeggies() {
        Veggie[] veggies = {
                new BlackOlive(),
                new Spinach(),
                new Eggplant()
        };
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clam creatClam() {
        return new FrozenClam();
    }

}
