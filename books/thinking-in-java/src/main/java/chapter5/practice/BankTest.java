package chapter5.practice;

/**
 * Modify the previosu exercise so that finalize() will always be  called.
 * @author liu.hua
 */
class WebBank1{
    boolean loggedIn = false;
    WebBank1(boolean logStatus){
        loggedIn = logStatus;
    }
    void logOut(){
        loggedIn = false;
    }

    @Override
    protected void finalize() throws Throwable {
        if(loggedIn){
            System.out.println("Error: still logged in");
        }
        // Normally, you'll also call the base-class version:
//         super.finalize();
    }
}
public class BankTest {
    public static void main(String[] args) {
        WebBank1 bank1 = new WebBank1(true);
        WebBank1 bank2 = new WebBank1(true);
        new WebBank1(true);
        // Proper cleanup: log out of bank1 before going home:
        bank1.logOut();
        // Forget to logout of bank2 and unnamed new bank
        // attempts to finalize any missed banks:
        System.out.println("Try 1: ");
        System.runFinalization();
        System.out.println("Try 2: ");
        Runtime.getRuntime().runFinalization();
        System.out.println("Try 3: ");
        System.gc();
        System.out.println("Try 1: ");
        // using deprecated since 1.1 method:
        System.runFinalizersOnExit(true);
    }
}
