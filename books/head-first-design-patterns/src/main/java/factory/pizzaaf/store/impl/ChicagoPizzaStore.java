package factory.pizzaaf.store.impl;

import factory.pizzaaf.Pizza;
import factory.pizzaaf.impl.CheesePizza;
import factory.pizzaaf.impl.ClamPizza;
import factory.pizzaaf.impl.PepperoniPizza;
import factory.pizzaaf.impl.VeggiePizza;
import factory.pizzaaf.factory.ingredientfactory.PIzzaIngredientFactory;
import factory.pizzaaf.factory.ingredientfactory.impl.ChicagoPizzaIngredientFactory;
import factory.pizzaaf.store.PizzaStore;

/**
 * @author lh
 */
public class ChicagoPizzaStore extends PizzaStore {
    @Override
    protected Pizza cretePizza(String type) {
        Pizza pizza = null;
        PIzzaIngredientFactory ingredientFactory = new ChicagoPizzaIngredientFactory();

        if(type.equals("cheese")){
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("Chicago Style Cheese Pizza");
        } else if (type.equals("veggie")){
            pizza = new VeggiePizza(ingredientFactory);
            pizza.setName("Chicago Style Veggie Pizza");
        }else if(type.equals("clam")){
            pizza = new ClamPizza(ingredientFactory);
            pizza.setName("Chicago Style Clam Pizza");
        } else if(type.equals("pepperoni")){
            pizza = new PepperoniPizza(ingredientFactory);
            pizza.setName("Chicago Style Pepperoni Pizza");
        }

        return pizza;
    }
}
