package chapter2.practice;

/**
 * @author lh
 */
public class StorageTest_p02_06 {
    public static void main(String[] args) {
        class StoreStuff{
            int storage(String s){
                return s.length() * 2;
            }
        }
        StoreStuff x = new StoreStuff();
        System.out.println(x.storage("hi"));
    }
}
