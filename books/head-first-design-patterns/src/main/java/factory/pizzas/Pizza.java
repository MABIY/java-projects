package factory.pizzas;

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
        System.out.println("Preparing " + name);
    }


    public void bake(){
        System.out.println("Backing " +name);
    }

    public void cut(){
        System.out.println("Cutting " + name);
    }

    public void box(){
        System.out.println("Boxing " + name);
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
