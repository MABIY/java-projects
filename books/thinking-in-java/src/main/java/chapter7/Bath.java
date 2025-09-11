package chapter7;

import static net.mindview.util.Print.print;

/**
 * Constructor initialization with composition
 * @author liu.hua
 */
class Soap{
   private String s;

   Soap(){
        print("Soap()");
        s = "Constructed";
   }

    @Override
    public String toString() {
        return s;
    }
}
public class Bath {
    private String // Initializing at point of definition:
            s1 ="Happy",
            s2 = "Happy",
            s3,s4;

    private Soap castille;
    private int i;
    private float toy;
    public Bath(){
        print("Inside Bath()");
        s3 = "joy";
        toy = 3.14f;
        castille = new Soap();
    }

    // Instance initialization:
    {
        i = 47;
    }

    @Override
    public String toString() {
        if(s4 == null) {//Delayed initialization:
            s4 = "Joy";
        }
        return "Bath{" +
                "s1='" + s1 + '\'' +
                ", s2='" + s2 + '\'' +
                ", s3='" + s3 + '\'' +
                ", s4='" + s4 + '\'' +
                ", castille=" + castille +
                ", i=" + i +
                ", toy=" + toy +
                '}';
    }

    public static void main(String[] args){
        Bath b =  new Bath();
        print(b);
    }
}
