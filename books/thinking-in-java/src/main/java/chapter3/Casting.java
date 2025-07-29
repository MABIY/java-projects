package chapter3;

/**
 * @author lh
 */
public class Casting {
    public static void main(String[] args) {
        int i = 200;
        long lng = (long) i;
        lng = i; //"widening." so cast not really required

        //<editor-fold desc="int compare double. float is same">
        double a = i;
        if (i == a) {
            //this will print, as 10.0f is equivalent to 10
            System.out.println("lng 200 equal double 200");
        }
        //</editor-fold>

        long lng2 = (long) 200;
        lng2 = 200;

        // A "narrowing conversion"
        i = (int) lng2;
    }
}
