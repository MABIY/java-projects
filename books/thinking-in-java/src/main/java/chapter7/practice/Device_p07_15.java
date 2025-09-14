package chapter7.practice;

import chapter7.practice.ex15.BasicDevice;

/**
 * Create a class inside a package. Your class should contain a protected
 * method. outside the package, try to call the protected method and explain
 * the results. Now inherit from your class and call the protected method from
 * inside a method of your derived class.
 * @author lh
 */
class DeviceFail {
    public static void main(String[] args){
        BasicDevice fail = new BasicDevice();
        fail.showS();
        // Can't access protected method
//        fail.changeS("good-bye");
    }
}
/**
 * @author lh
 */
public class Device_p07_15 extends BasicDevice{
    void changeBasic(String t){
        // calls protected method
        super.changeS(t);
    }
    public static void main(String[] args){
        Device_p07_15 d = new Device_p07_15();
        d.showS();
        //derived class can access protectd
        d.changeBasic("changed");
        d.showS();
        DeviceFail.main(args);
    }
}
