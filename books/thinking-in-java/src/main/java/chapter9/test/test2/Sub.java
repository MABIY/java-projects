package chapter9.test.test2;

import chapter9.test.test1.Parent;

/**
 * @author lh
 */
public class Sub extends Parent {
    public static String name = initName();

    static {
        System.out.println("sub static block1 inited");
    }

    private static String initName() {
        System.out.println(Parent.nameInit());
        System.out.println("sub static name inited");
        return "sub static name";
    }
    public static void main(String[] args){
        new Sub();
    }
}
