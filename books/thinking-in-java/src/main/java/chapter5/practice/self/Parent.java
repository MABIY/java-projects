package chapter5.practice.self;

/**
 * @author liu.hua
 */
public class Parent {
    protected String name = "parent";

    public void print() {
        System.out.println(this);
    }

    public String getName() {
        return name;
    }
}
