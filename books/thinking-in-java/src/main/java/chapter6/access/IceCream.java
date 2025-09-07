package chapter6.access;


/**
 * Demonstrates "private" keyword
 * @author liu.hua
 */
class Sundae{
    private Sundae(){

    }
    static Sundae makeASundate(){
        return new Sundae();
    }
}

public class IceCream {

    public static void main(String[] args){
        //! Sundae x = new Sundae();
        Sundae x = Sundae.makeASundate();
    }

}
