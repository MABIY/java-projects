package net.mindview.util;

import java.io.PrintStream;

/**
 * @author lh
 */
public class Print {

    public static void print(Object object) {
        System.out.println(object);
    }

    public static void print(){
        System.out.println();
    }

    public static void printnb(Object object){
        System.out.print(object);
    }

    public static PrintStream printf(String string, Object... args){
        return System.out.printf(string, args);
    }

}
