package chapter8.practice;

import static org.greggordon.tools.Print.println;

/**
 * Create a Cycle class, with subclasses Unicycle,Bicycle and Tricycle.
 * Demonstrate that an instance of each type can be upcast to Cycle via a ride()
 * method.
 * @author lh
 */
class Cycle {
    private String name = "Cycle";
    public static void trave(Cycle c){
        println("Cycle.ride()" + c);
    }

    @Override
    public String toString() {
        return "Cycle{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Unicycle extends Cycle{
    public static String name = "Unicycle";

    @Override
    public String toString() {
        return "Unicycle{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Bicycle extends Cycle{
    private String name ="Bicycle";

    @Override
    public String toString() {
        return "Bicycle{" +
                "name='" + name + '\'' +
                '}';
    }
}
class Tricycle extends Cycle{
    private String name ="Tricycle";

    @Override
    public String toString() {
        return "Ticycle{" +
                "name='" + name + '\'' +
                '}';
    }
}


public class Biking_p08_01 {
    public static void ride(Cycle c) {
        Cycle.trave(c);
    }
    public static void main(String[] args){
        Unicycle u = new Unicycle();
        Bicycle b = new Bicycle();
        Tricycle t = new Tricycle();
        ride(u);
        ride(b);
        ride(t);
    }

}
