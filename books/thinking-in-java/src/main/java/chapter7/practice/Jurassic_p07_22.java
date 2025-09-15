package chapter7.practice;
/**
 * Create a final class and attempt to inherit from it
 * @author lh
 */
class SmallBrain{}
final class Dinosaur{
    SmallBrain x = new SmallBrain();
}
//class Further extends Dinosaur{} // error: cannot inherit from final Dinosaur
public class Jurassic_p07_22 {
    public static void main(String[] args){
        Dinosaur d = new Dinosaur();
    }
}
