package chapter7;
/**
 * "Blank" final fields.
 * @author lh
 */
class Poppet{
    private int i;
    Poppet(int ii){
        i = ii;
    }
}
public class BlankFinal {
    // initialized final
    private final int i = 0;
    // Blank final reference
    private final int j;
    private final Poppet p; // Blank final reference
    // Blank finals MUST be initialized in the constructor:

    public BlankFinal() {
        j = 1; // Initialize blank final
        p = new Poppet(1); // Initialize blank final reference
    }

    public BlankFinal(int x){
        j = x ;// Initialize blank final
        p = new Poppet(x); // Initialize blank final reference
    }

    public static void main(String[] args){
        new BlankFinal();
        new BlankFinal(47);
    }
}
