package chapter5;

import static chapter5.practice.self.JvmRuntimeInfo.bytesToMb;

/**
 * @author liu.hua
 */
class Book {
    boolean checkedOut = false;
    Book(boolean checkout){
        checkedOut = checkout;
    }

    void checkIn() {
        checkedOut = false;
    }

    @Override
    protected void finalize(){
        System.out.println("start: check");
        if(checkedOut) {
           System.out.println("Error: checked out");
           // Normally, you'll also do this:
//           super.finalize(); // call the base-class version
       }
    }
}
public class TerminationCondition {
    public static void main(String[] args) {
        Book novel = new Book(true);
        // Proper cleanup:
        novel.checkIn();
        //Drop the reference, forget to clean up
        new Book(true);
        // Force garbage collection & finalization:
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

        System.gc();
    }

}
