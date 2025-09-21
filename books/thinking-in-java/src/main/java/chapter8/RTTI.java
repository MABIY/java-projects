package chapter8;
/**
 * Down-casting & Runtime type information (RTTI)
 * @author lh
 */
class Useful {
    public void f(){}
    public void g(){}
}

class MoreUseful extends Useful {
    @Override
    public void f() {
    }

    @Override
    public void g() {
    }

    public void u(){

    }
    public void v(){}
    public void w(){}
}
public class RTTI {

    public static void main(String[] args){
        Useful[] x = {
                new Useful(),
                new  MoreUseful()
        };

        x[0].f();
        x[1].g();
        // Compile time: method not found in useful:
        //        x[1].u();

        // DownCase/RTTI
        ((MoreUseful) x[1]).u();
        // Exception thron
        ((MoreUseful) x[0]).u();
    }
}
