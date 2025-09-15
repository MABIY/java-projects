package chapter7.practice;

import static net.mindview.util.Print.print;

/**
 * Create a class with a final method. Inherit from that class and attempt to
 * override that method.
 * @author lh
 */

class WithFinal{

    final void f(){
        print("WithFinal.f()");
    }
    void g(){
        print("WithFinal.g()");
    }
    final void h(){
        print("WithFinal.h()");
    }
}

class OverrideFinal extends WithFinal{

    //attempt to override:
//    public  void f(){ // no can do
//        print("OverrideFinal.f()");
//    }

    @Override
    public void g(){
        print("OverrideFinal.g()");
    }

    // Can't override final
//    final void h(){
//        print("OverrideFinal.h()");
//    }
}
public class FinalOverrideEx {
    public static void main(String[] args){
        OverrideFinal of = new OverrideFinal();
        of.f();
        of.g();
        of.h();
        // Upcast:
        WithFinal wf = of;
        wf.f();
        wf.g();
        wf.h();
    }
}
