package factory.pizzafm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lh
 */
public abstract class Pizza {
    protected String name;
    protected String dough;
    protected String sauce;
    protected List<String> toppings = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void prepare(){
        System.out.println("Prepare " +name);
        System.out.println("Tossing dough...");
        System.out.println("Adding sauce...");
        System.out.println("adding toppings: ");
        for (String topping : toppings) {
            System.out.println("  " + topping);
        }
    }


    public void bake(){
        System.out.println("Bake for 25 minutes at 350");
    }

    public void cut(){
        System.out.println("Cut the pizza into diagonal slices");
    }

    public void box(){
        System.out.println("Place pizza in official PizzaStore box");
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pizza{");
        sb.append("name='").append(name).append('\'');
        sb.append(", dough='").append(dough).append('\'');
        sb.append(", sauce='").append(sauce).append('\'');
        sb.append(", toppings=").append(toppings);
        sb.append('}');
        return sb.toString();
    }
}
