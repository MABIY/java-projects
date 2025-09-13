package org.greggordon.tools;

import java.io.PrintStream;

/**
 * prit and println shorthand
 * uing java SE5 static imports
 * modified from TIJ4 (than you Bruce Eckel)
 * @author liu.hua
 */
public class Print {

    //print with a newline:
    public static void println(Object obj) {
        System.out.println(obj);
    }

    // Print newline:
    public static void println(){
        System.out.println();
    }

    // Print with no line break:
    public static void print(Object obj){
        System.out.print(obj);
    }
    // The new Java SE5 printf() (from c):
    public static PrintStream printf(String format,Object... args){
        return System.out.printf(format, args);
    }
}
