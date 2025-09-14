package chapter7.practice;

import org.eclipse.swt.internal.C;

import static net.mindview.util.Print.print;

/**
 * @author lh
 */

class Cleanser11{
    private String s = "Cleanser ";

    public void append(String a) {
        s += a;
    }

    public void dilute() {
        append("dilute()");
    }

    public void apply() {
        append(" apply()");
    }
    public void scrub(){
        append(" scrub()");
    }

    @Override
    public String toString() {
        return s;
    }
    public static void main(String[] args){
        Cleanser11 x = new Cleanser11();
        print(x);
    }
}
public class DetergentDelegation {
    private String s = "DetergentDelegation";

    public void append(String a) {
        c.append(a);
    }

    public void dilute() {
        c.dilute();
    }

    public void apply() {
        c.apply();
    }

    // method delegated in part fo Cleanser c:
    public void scrub() {
        append(" DetergentDelegation.scrub()");
        c.scrub();
    }

    public void foam(){
        append(" foam()");
    }

    @Override
    public String toString() {
        return s + " " + c;
    }

    Cleanser11 c = new Cleanser11();

    public static void main(String[] args){
        DetergentDelegation x = new DetergentDelegation();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        print(x);
        print("Testing base class:");
        Cleanser11.main(args);
    }
}
