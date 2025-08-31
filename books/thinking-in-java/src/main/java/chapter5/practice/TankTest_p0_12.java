package chapter5.practice;

/**
 * @author liu.hua
 */
class  Tank {
    public static int i = 0;
    int howFull = 0;
    Tank() {
        this(0);
    }
    Tank(int fullness){
        howFull = fullness;
    }

    void sayHowFull() {
        if(howFull ==0){
            System.out.println("Tank is empty");
        } else {
            System.out.println("Tank filling status = " + howFull);
        }
    }

    void empty(){
        howFull = 0;
    }

    @Override
    protected void finalize() throws Throwable {
        if(howFull !=0){
            System.out.println("Error: Tank not empty"+this.howFull);
        }
        // Normally, you'll also do this:
        // super.finalize();//Call the base-class version
    }
}
public class TankTest_p0_12 {
    public static void main(String[] args) {
        Tank tank1 = new Tank();
        Tank tank2 = new Tank(3);
        Tank tank3 = new Tank(5);
        Tank tank4 = new Tank(7);
        // Proper cleanup: empty tank before going home
        tank2.empty();
        // Drop the reference, forget to cleanup:
        new Tank(6);
        System.out.println("Check tansk:");
        System.out.println("tank1:");
        tank1.sayHowFull();
        System.out.println("tank2: ");
        tank2.sayHowFull();
        System.out.println("tank3: ");
        tank3.sayHowFull();
        System.out.println("first forced gc():");
        System.gc();
        // Force inalization on exit but using method
        // Deprecated since jdk1.1
        System.out.println("try deprecated runfinalizersonExit(true):");
        System.runFinalizersOnExit(true);
        System.out.println("last force gc()");
        System.gc();
        System.out.println(tank3);
        System.out.println("end");
    }
}
