package chapter2.practice;/**
 * @author lh
 */
public class DOTest2_p02_05 {
    public static void main(String[] args) {
        class DataOnly{
            int i;
            double d;
            boolean b;
            void show(){
                System.out.println(i);
                System.out.println(d);
                System.out.println(b);
            }
        }
        DataOnly data = new DataOnly();
        data.i = 234;
        data.d = 2.123454512345459934545;
        data.b = true;
        data.show();
    }
}
