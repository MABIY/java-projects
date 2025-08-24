package chapter3.practice;

import static net.mindview.util.Print.print;

/**
 * @author lh
 */
public class DogCompare_p03_06 {
    public static void main(String[] args) {
        Dog spot = new Dog();
        spot.setName("Spot");
        spot.setSays("Ruff!");
        Dog scruffy = new Dog();
        scruffy.setName("Scruffy");
        scruffy.setSays("Wurf!");
        spot.showName();
        spot.speak();
        scruffy.showName();
        scruffy.speak();

        Dog butch = new Dog();
        butch.setName("Butch");
        butch.setSays("Hello!");
        butch.showName();
        butch.speak();

        print("Comparison: ");
        print("spot == butch: " + (spot == butch));
        print("spot.equals(butch): " + spot.equals(butch));
        print("butch.equals(spot): " + butch.equals(spot));
        print("Now assign: spot = butch");
        spot = butch;
        print("spot == butch: " + (spot == butch));
        print("spot.equals(butch): " + spot.equals(butch));
        print("butch.equals(spot): " + butch.equals(spot));
        print("Sport:");
        spot.showName();
        spot.speak();
        print("Butch:");
        butch.showName();
        butch.speak();
    }

    static class Dog {
        String name;
        String says;

        public void setName(String name) {
            this.name = name;
        }

        public void setSays(String says) {
            this.says = says;
        }

        void showName() {
            print(name);
        }

        void speak() {
            print(says);
        }
    }
}
