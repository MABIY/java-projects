package chapter5;

/**
 * @author liu.hua
 */
public class VarargType {
    static void f(Character... args){
        System.out.print(args.getClass());
        System.out.println(" length " + args.length);
    }

    static void g(int... args){
        System.out.print(args.getClass());
        System.out.println(" length " + args.length);
    }

    public static void main(String[] args) {
        f('a');
        f();
        g(1);
        g();

    }
}
