package chapter8;

import static org.greggordon.tools.Print.println;

/**
 * Following the exmaple in Transmogrify.java create a StarShip class
 * containing an AlbertStatus reference that can indicate three different status.
 * Include methods to change the status
 * @author lh
 */

class AlbertStatus{
   public void alert(){}
}

class NormalAlert extends AlbertStatus{
    public void alert(){
        println("AlertStatus Normal");
    }
}

class HighAlert extends AlbertStatus{
    @Override
    public void alert() {
        println("AlertStatus High");
    }
}
class MaximumAlert extends AlbertStatus{
    @Override
    public void alert() {
        println("AlertStatus Maximum");
    }
}

class Starship{
    private AlbertStatus albertStatus = new NormalAlert();
    public void normalAlert(){
       albertStatus = new NormalAlert();
    }
    public void highAlbert(){
        albertStatus = new HighAlert();
    }

    public void maximumAlert(){
        albertStatus = new MaximumAlert();
    }

    public void checkAlertStatus(){
        albertStatus.alert();
    }
}
public class Transmogrify_p08_16 {
    public static void main(String[] args){
       Starship ss =new Starship();
       ss.checkAlertStatus();

       ss.highAlbert();
       ss.checkAlertStatus();

       ss.maximumAlert();
       ss.checkAlertStatus();

       ss.normalAlert();
        ss.checkAlertStatus();

    }
}
