package chapter8.biking17;

import static net.mindview.util.Print.print;
import static org.greggordon.tools.Print.println;

/**
 * Using the Cycle hierarchy from exercise 1, add a balance method() to 
 * Unicycle and Bicycle ,but not to Tricycle. Create instance of all three 
 * types and upcast them to an array of Cycle. Try to call balance() on each
 * element of the array an observe the results. Downcast and call balance() and
 * observe what happens.
 * @author lh
 */
class Cycle {
    private String name = "Cycle";
    public static void travel(Cycle c){
        print("Cycle.ride()" + c);
    }

    @Override
    public String toString() {
        return name;
    }
}

class Unicycle extends Cycle{
    private String name = "Unicycle";
    public void balance(){
        println("Balance Unicycle");
    }

}
class Bicycle extends Cycle{
    private String name = "Bicycle";
    public void balance(){
        println("Balance Bicycle");
    }

}
class Tricycle extends Cycle{
    private String name = "Tricycle";

}

public class Biking_p08_17 {
    public static void main(String[] args){
        Cycle[] ride ={
                new Unicycle(),
                new Bicycle(),
                new Tricycle()
        };
       // Compile time error: cannot find balance() method in cycle:
//        for (Cycle c : ride) {
//            c.balance();
//        }
        ((Unicycle)ride[0]).balance();
        ((Bicycle)ride[1]).balance();
        // Compile time error: no balance() in Tricycle:
//        ((Tricycle) ride[2]).balance();
        // RTTI: classCastException:Tricycle cannot be cast to Bicycle:
//        ((Bicycle)ride[2]).balance();

    }
}
