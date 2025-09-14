package chapter7.practice.ex15;
/**
 * @author lh
 */
public class BasicDevice {
    private String s = "Original";
    public BasicDevice(){
        s = "Original";
    }

    /**
     *
     * outside package, only derived
     * classes can access protected method
     * @param c the c
     */
    protected void changeS(String c) {
       s =c;
    }
    public void showS(){
        System.out.println(s);
    }
}
