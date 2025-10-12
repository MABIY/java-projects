package factory.pizzaaf;

import factory.pizzaaf.ingredients.cheese.Cheese;
import factory.pizzaaf.ingredients.clam.Clam;
import factory.pizzaaf.ingredients.dough.Dough;
import factory.pizzaaf.factory.ingredientfactory.PIzzaIngredientFactory;
import factory.pizzaaf.ingredients.pepperoni.Pepperoni;
import factory.pizzaaf.ingredients.sauce.Sauce;
import factory.pizzaaf.ingredients.veggie.Veggie;

import java.util.Arrays;

/**
 * @author lh
 */
public abstract class Pizza {
    protected PIzzaIngredientFactory ingredientFactory;

    public Pizza(PIzzaIngredientFactory pIzzaIngredientFactory) {
        this.ingredientFactory = pIzzaIngredientFactory;
    }

    protected String name;

    protected Dough dough;
    protected Sauce sauce;
    protected Veggie veggies[];
    protected Cheese cheese;
    protected Pepperoni pepperoni;
    protected Clam clam;

    public abstract void prepare();

    public void bake(){
        System.out.println("Bake for 25 minutes at 350");
    }

    public void cut(){
        System.out.println("Cutting the pizza into diagonal slices");
    }

    public void box(){
        System.out.println("Place pizza in official PizzaStore box");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", dough=" + dough +
                ", sauce=" + sauce +
                ", veggies=" + Arrays.toString(veggies) +
                ", cheese=" + cheese +
                ", pepperoni=" + pepperoni +
                ", clam=" + clam +
                '}';
    }
}
