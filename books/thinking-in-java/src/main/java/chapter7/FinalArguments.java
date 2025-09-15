package chapter7;
/**
 * @author lh
 */
class Gizmo{
    public void spin(){}
}
public class FinalArguments {
    void with(final Gizmo g){
        //Illegal  -- g is final
//       g= new Gizmo();
    }

    void without(Gizmo g){
        // Ok -- g not final
        g = new Gizmo();
        g.spin();
    }

//    void f(final  int i){
//        //Can't change you can only read form a final primitive
//        i++;
//    }
    int g(final  int i){
        return i + 1;
    }

    public static void main(String[] args){
        FinalArguments bf = new FinalArguments();
        bf.without(null);
        bf.with(null);
    }
}
