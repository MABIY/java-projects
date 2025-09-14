package chapter7.practice;

import static net.mindview.util.Print.print;

/**
 * Using Chess.java, prove the statements in the previous paragraph.(if you
 * don't call the base class construcotr in BoardGame(), the compiler will
 * complain that it can't find a constructor of the form Game(). In addition, the
 * call to the base-class constructor must be the first thin you do in the
 * derived-class constructor. The compiler will remind you if you get it wrong.
 * @author lh
 */
class Game {
    Game(int i) {
        print("Game constructor");
    }
}

class BoardGame extends Game {
    BoardGame(int i) {
        // Call to super must be first statement in constructor
        //        print("BoardGame constructor");
        // else: "cannot find symbol:construcotr Game()"
        super(i);
        print("BoardGame constructor");
    }
}

/**
 * @author lh
 */
public class Chess_p07_06 extends BoardGame{
    Chess_p07_06(){
        super(11);
        print("Chess constructor");
    }
    public static void main(String[] args){
        Chess_p07_06 x = new Chess_p07_06();
    }
}
