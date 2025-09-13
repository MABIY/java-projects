package chapter7;


import static net.mindview.util.Print.print;

/**
 * Constructor calls during inheritance.
 * @author lh
 */
class Art{
    Art(){
        print("Art constructor");
    }
}

class Drawing extends Art{
    {
        System.out.println("Drawing instance init");
    }
    Drawing(){
        print("Drawing constructor");
    }
}
public class Cartoon extends Drawing {
    public Cartoon(){
        print("Cartoon constructor");
    }

    public static void main(String[] args){
        Cartoon x = new Cartoon();
    }


}
