package chapter7.practice;

import static net.mindview.util.Print.print;

/**
 * Show that the @Override annotation solves the problem in the section
 * @author lh
 */
class WithFinals {
    // Identical to private alone
    private final void f() {
        print("WithFinals.f()");
    }

    // also automatically "final"
    private void g() {
        print("WithFinals.g()");
    }
}

class OverridingPrivate extends WithFinals {
    // attempt to override:

    private final void f() {
        print("OverridingPrivate.f()");
    }

    private void g() {
        print("OverridingPrivate.g()");
    }
}
//    @Override
//    private final void f(){
//        print("OverridingPrivate.f()");
//    }
//    @Override
//    private void g(){
//        print("OverridingPrivate.g()");
//    }
//
class OverridingPrivate2 extends chapter7.practice.OverridingPrivate {
    // Attempt to override:
    public final void f() {
        print("OverridingPrivate2.f()");
    }

    public void g() {
        print("OverridingPrivate2.g()");
    }
    //    @Override
    //    public final void f(){
    //        print("OverridingPrivate.f()");
    //    }
    //    @Override
    //    public void g(){
    //        print("OverridingPrivate.g()");
    //    }
}

public class FinalOverridingIllusion_p07_20 {
    public static void main(String[] args) {
        OverridingPrivate2 op2 = new OverridingPrivate2();
        op2.f();
        op2.g();
        // You can upcast
        OverridingPrivate op = op2;
        // But you can't call the method:
//        op.f(); // f() has private access in OverridingPrivate
//        op.g();
        // Same here:
        WithFinals  wf = op2;
//        wf.f() // f() has private access in WithFinals
//        wf.g();

    }
}
