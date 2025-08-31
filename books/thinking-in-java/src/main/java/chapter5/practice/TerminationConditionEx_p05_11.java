package chapter5.practice;

import static chapter5.practice.self.JvmRuntimeInfo.bytesToMb;

/**
 * @author liu.hua
 */
class WebBank{
    boolean loggedIn = false;
    private  int a = 0;

    WebBank(boolean logStatus,int a ){
        loggedIn = logStatus;
        this.a = a;
    }

    void logIn(){
        loggedIn = true;
    }
    void logOut() {
        loggedIn = false;
    }

    @Override
    protected void finalize() {
       if(loggedIn) {
           System.err.println(a + "-> Error: still logged in");
       }
    }
}
/**
 * @author liu.hua
 */
public class TerminationConditionEx_p05_11 {
    public static void main(String[] args) {
        WebBank bank1 = new WebBank(true,0);
        WebBank bank2 = new WebBank(true,1);
        // Proper cleanup: log out of bank1 before going home
//        bank1.logOut();
        // Drop the reference, forget to cleanup:
        new WebBank(true,2);
        Runtime runtime = Runtime.getRuntime();
        // Get total heap Memory allocated to the JVM in bytes
        long totalMemory = runtime.totalMemory();
        //Get maximum heap memory that the JVM can use in bytes
        long maxMemory = runtime.maxMemory();
        // Get free heap memory available in the jvm in bytes
        long freeMemory = runtime.freeMemory();

        //Convert bytes to megabytes for better readability
        long totalMemoryMB = bytesToMb(totalMemory);
        long maxMemoryMB = bytesToMb(maxMemory);
        long freeMemoryMB = bytesToMb(freeMemory);
        System.out.println("JVM Heap memory Information:");
        System.out.println("Total Memory (allocated): " + totalMemoryMB+ " MB");
        System.out.println("Max Memory (maximum available): " + maxMemoryMB+ " MB");
        System.out.println("Free Memory (available for new objects)" + freeMemoryMB+ " MB");

        // Forece garbage collection and finalization:
        System.gc();
        // using deprecated since 1.1 method:
        System.runFinalizersOnExit(true);
    }
}
