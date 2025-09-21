package chapter8;

import static net.mindview.util.Print.print;

/**
 * trying to override a private method:
 * @author lh
 */
public class PrivateOverride {
    private void f(){
        print("private  f()");
    }
    public static void main(String[] args){
        PrivateOverride po = new Derived();
        po.f();
    }
}

class Derived extends PrivateOverride{
    public void f(){
        print("public f()");
    }
}
