package chapter2.practice;

/**
 * @author lh
 */
public class ATNTest_p2_03 {
    public static void main(String[] args) {
        class ATypeName{
            int i;
            double d;
            boolean b;
            void show(){
                System.out.println(i);
                System.out.println(d);
                System.out.println(b);
            }
        }
        ATypeName a = new ATypeName();
        // show default value
        System.out.println("show default value");
        a.show();
        a.i=3;
        a.d = 2.71828;
        a.b = false;
        System.out.println("show set value");
        a.show();
    }
}
