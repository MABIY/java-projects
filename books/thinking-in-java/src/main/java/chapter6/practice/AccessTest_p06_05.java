package chapter6.practice;
/**
 * Create a class with four, private,protected and pacakge-access fields and
 * method members. Create an object of this class and see what kind of compiler
 * messages you get when you try to access all the class members. Be aware that
 * classes in the same directory are part of the "default" pacakge.
 *
 * @author liu.hua
 */
public class AccessTest_p06_05 {
    public static void main(String[] args){
        FourWays fw =new FourWays();
        fw.showa();
        fw.showb();
        fw.showc();
        fw.a =10;
        fw.b = 20;
        fw.c = 30;
        //!fw.d =40; // private access
        fw.showa();
        fw.showb();
        fw.showc();
        //!fw.showd() // private access, compiler can't touch

    }
}
class FourWays {
    int a =0;
    public int b =1;
    protected int c =2;
    private int d = 3;
    FourWays() {
        System.out.println("FourWays() constructor");
    }

    void showa(){
        System.out.println(a);
    }

    public void showb() {
        System.out.println(b);
    }
    protected void showc() {
        System.out.println(c);
    }

    private void showd() {
        System.out.println(d);
    }
}

