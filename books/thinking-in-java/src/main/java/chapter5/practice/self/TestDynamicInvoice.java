package chapter5.practice.self;

/**
 * @author liu.hua
 */
public class TestDynamicInvoice {
    public static void main(String[] args) {
        Parent parent = new Sub();
        System.out.println(parent.name);
        System.out.println(((Sub)parent).name);
        System.out.println(parent.getName());
        System.out.println(((Sub)parent).getName());
        parent.print();


        Parent parent1 = new Parent();
        System.out.println(parent1.name);
        System.out.println(parent1.getName());
        parent1.print();

    }
}

// result: method is multiple Polymorphism,but field is not