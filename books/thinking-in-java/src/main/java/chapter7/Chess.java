package chapter7;

import static net.mindview.util.Print.print;

/**
 * Inheritance, constructors and arguments.
 * @author lh
 */

class Game{
    Game(int i){
        print("Game constructor");
    }

    {
        System.out.println("Game instance init block");
    }
}
class BoardGame extends Game {
    {
        System.out.println("BoardGame instance init block");
    }
    BoardGame(int i){
        super(i);
        print("BoardGame constructor");
    }
}
public class Chess extends BoardGame{
   Chess() {
       super(11);
        print("Chess constructor");
   }

   public static void main(String[] args){
       Chess x = new Chess();
   }
}
