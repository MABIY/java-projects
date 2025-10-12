package factory.pizzafm.stores.chicago.products;

import factory.pizzafm.Pizza;

/**
 * @author lh
 */
public class ChicagoStylePepperoniPizza extends Pizza {
    public ChicagoStylePepperoniPizza() {
        name = "Chicago Style Pepperoni Pizza";
        dough ="extra Thick Crust Dough";
        sauce = "Plum Tomato Sauce";

        toppings.add("Shredded Mozzarella Cheese");
        toppings.add("Black olives");
        toppings.add("Spinach");
        toppings.add("Eggplant");
        toppings.add("Sliced Pepperoni");

    }

    @Override
    public void cut() {
        System.out.println("Cutting the pizza into square slice");
    }
}
