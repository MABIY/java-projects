package chapter5.practice.self;


/**
 * @author liu.hua
 */
public class JvmRuntimeInfo {
    public static void main(String[] args) {
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
    }

    public static long bytesToMb(long bytes){
        return bytes / (1024 * 1024);
    }

}
