package chapter9.practice.ex6;
/**
 * @author lh
 */
public class Ex6b implements Ex6 {
    // <editor-fold desc="Error: cannot assign weaker access to public methods: must be maintained public:">
    //    void sayOne() {
    //        System.out.println("one");
    //    }
    //
    //    protected void sayTwo() {
    //        System.out.println("two");
    //    }
    //
    //    private void sayThree() {
    //        System.out.println("three");
    //    }
    // </editor-fold>

    @Override
    public void sayOne() {
        System.out.println("one");
    }

    @Override
    public void sayTwo() {
        System.out.println("two");
    }

    @Override
    public void sayThree() {
        System.out.println("three");
    }
}
