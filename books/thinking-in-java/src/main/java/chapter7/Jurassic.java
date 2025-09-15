package chapter7;
/**
 * Making an entire class final.
 * @author lh
 */
class SmallBrain{}
final class Dinosaur{
    int i =7;
    int j = i;
    SmallBrain x = new SmallBrain();
    void  f(){}
}
//!class Further extends Dinosaur{}
// error: cannot extend final class 'Dinosaur'
public class Jurassic {
    public static void main(String[] args){
        Dinosaur n = new Dinosaur();
        n.f();
        n.i =40;
        n.j++;
    }
}


