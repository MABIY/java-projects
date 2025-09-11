package chapter7.practice;

import static net.mindview.util.Print.print;

/**
 * Create a simple class. Inside a second class, definie a reference to an object of
 * the first clas. use lazy initialization to instantiate this object.
 * @author liu.hua
 */
class Engine {
    private String s;
    Engine(){
        print("Engine()");
        s = "Constructed";
    }

    @Override
    public String toString() {
        return s;
    }
}
public class Airplane_p07_01 {
    private String fuselage, wings, tail;
    private Engine e;

    public Airplane_p07_01() {
        print("Inside Airplane()");
        fuselage = "body";
        wings = "Airfoils";
        tail = "Empennage";
    }

    @Override
    public String toString() {
        //Lazy (delayed) initialization:
        if(e ==null) {
            e = new Engine();
        }
        return "Airplane_p07_01{" +
                "fuselage='" + fuselage + '\'' +
                ", wings='" + wings + '\'' +
                ", tail='" + tail + '\'' +
                ", e=" + e +
                '}';
    }

    public static void main(String[] args){
        Airplane_p07_01 N1234 = new Airplane_p07_01();
        print(N1234);
    }
}
