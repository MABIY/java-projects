package chapter7;
/**
 * Composition for code reuse.
 * @author liu.hua
 */
class WaterSource{
    private String s;
    WaterSource() {
        System.out.println("WaterSource()");
        s= "Constructed";
    }

    @Override
    public String toString(){
        return s;
    }
}
public class SpinklerSystem {

    private String value1, value2,value3,value4;
    private WaterSource source = new WaterSource();
    private int i;
    private float f;

    @Override
    public String toString() {
        return "SpinklerSystem{" +
                "value1='" + value1 + '\'' +
                ", value2='" + value2 + '\'' +
                ", value3='" + value3 + '\'' +
                ", value4='" + value4 + '\'' +
                ", source=" + source +
                ", i=" + i +
                ", f=" + f +
                '}';
    }

    public static void main(String[] args){
        SpinklerSystem sprinkiers  =new SpinklerSystem();
        System.out.println(sprinkiers);
    }
}
