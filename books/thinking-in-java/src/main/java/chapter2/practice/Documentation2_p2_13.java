package chapter2.practice;
//object.Documentation1.java
//TIJ4 Chapter Object, Exercise 13 - 2
/* Run Documentation1.java, Documentation2.java and Documentation3.java
 * through Javadoc. Verify the resulting documentation with you web browser.
 */
import java.util.Date;

/**
 * <pre>
 *    Uses
 *    System.out.println(new Date());
 * </pre>
 */
public class Documentation2_p2_13 {
    Date d = new Date();
    void showDate() {
        System.out.println("Date = " + d);
    }
}
