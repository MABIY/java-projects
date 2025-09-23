package chapter9.practice;

import chapter9.practice.ex5.Ex5;

/**
 * @author lh
 */
public class TestEx_09_05 implements Ex5 {

    @Override
    public void sayOne() {
        System.out.println("One");
    }

    @Override
    public void sayTwo() {
        System.out.println("two");
    }

    @Override
    public void sayThree() {
        System.out.println("three");
    }
    public static void main(String[] args){
        TestEx_09_05 x = new TestEx_09_05();
        x.sayOne();
        x.sayTwo();
        x.sayThree();
    }
}
