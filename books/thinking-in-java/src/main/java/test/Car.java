package test;

import lombok.Getter;
import lombok.Setter;

/**
 * @author lh
 */
class Engine{
    public void start(){}
    public void rev(){}
    public void stop(){}
}

class Wheel{
    public void inflate(int psi){}
}

class Window{
    public void rollup(){}
    public void rolldown(){}
}

@Setter
@Getter
class Door{
    private Window window = new Window();

    public void open(){}
    public void close(){}
}
@Getter
@Setter
public class Car {
    private Engine engine = new Engine();
    private Wheel[] wheels = new Wheel[4];
    private Door left = new Door(),
    // 2-door
    right = new Door();

    public Car() {
        for(int i = 0; i < wheels.length; i++) {
           wheels[i]  = new Wheel();
        }
    }

    public static void main(String[] args){
        Car car = new Car();
        car.getLeft().getWindow().rollup();
        car.getWheels()[0].inflate(72);
    }
}

