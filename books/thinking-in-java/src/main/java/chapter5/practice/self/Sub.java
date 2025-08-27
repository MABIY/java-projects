package chapter5.practice.self;

/**
 * @author liu.hua
 */
public class Sub extends Parent {
    protected String name = "sub";
    @Override
    public void print() {
        System.out.println(this);
    }

    public String getName() {
        return name;
    }
}
