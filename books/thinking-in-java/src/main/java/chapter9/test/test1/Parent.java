package chapter9.test.test1;

import chapter9.test.test2.Sub;

/**
 * @author lh
 */
public class Parent {
    static {
        System.out.println("parent static block1 inited");
    }

    public static String name = nameInit();

    static {
        System.out.println("parent static block2 inited");
    }

    public static String nameInit(){
        System.out.println("invoke Sub static name field");
        System.out.println("invoke Sub static name field value:" + Sub.name);
        System.out.println("Parent static name inited");
        return "Parent static name";
    }

    public static void main(String[] args){
        new Sub();
    }
}
