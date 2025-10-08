package factory.pizzaaf.store.impl;

import factory.pizzaaf.Pizza;
import factory.pizzaaf.impl.CheesePizza;
import factory.pizzaaf.impl.ClamPizza;
import factory.pizzaaf.impl.PepperoniPizza;
import factory.pizzaaf.impl.VeggiePizza;
import factory.pizzaaf.factories.ingredientfactory.PIzzaIngredientFactory;
import factory.pizzaaf.factories.ingredientfactory.impl.NYPizzaIngredientFactory;
import factory.pizzaaf.store.PizzaStore;

/**
 * @author lh
 */
public class NYPizzaStore extends PizzaStore {
    @Override
    protected Pizza cretePizza(String type) {
        Pizza pizza = null;
        PIzzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();

        if(type.equals("cheese")){
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("New York Style Cheese Pizza");
        } else if (type.equals("veggie")){
            pizza = new VeggiePizza(ingredientFactory);
            pizza.setName("New York Style Veggie Pizza");
        }else if(type.equals("clam")){
            pizza = new ClamPizza(ingredientFactory);
            pizza.setName("New York Style Clam Pizza");
        } else if(type.equals("pepperoni")){
            pizza = new PepperoniPizza(ingredientFactory);
            pizza.setName("New York Style Pepperoni Pizza");
        }

        return pizza;

    }
}
