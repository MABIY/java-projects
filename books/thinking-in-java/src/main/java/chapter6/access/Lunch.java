package chapter6.access;

/**
 * Demonstrates class access specifiers
 * @author liu.hua
 */
class Soup1{
    private Soup1(){}

    // (1) allow creation via static method:
    public static Soup1 makeSoup(){
        return new Soup1();
    }
}

class Soup2{
    //(2) create a static object and return a reference
    // upon request. (The "singleton" pattern)
    private static final Soup2 ps1 = new Soup2();

    private Soup2(){}

    public static Soup2 access(){
        return ps1;
    }

    public void f(){}

}

// Only one public class allowed per file
public class Lunch {
    void testPrivate(){
        // Can't do this! Private constructor
        //! Soup1 soup = new Soup1();
    }

    void testStatic(){
        Soup1 soup = Soup1.makeSoup();
    }

    void testSingleton(){
        Soup2.access().f();
    }

}
