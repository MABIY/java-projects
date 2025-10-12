package factory.challenge.calendars;

import factory.challenge.zone.Zone;

import java.util.List;

/**
 * @author lh
 */
public abstract  class Calendar {
    protected Zone zone;


    public void print(){
        System.out.println("--- " + zone.getDisplayName() +" Calendar ---");
        // print all appointments in correct time zone
        System.out.println("Offset from GMT: " + zone.getOffset());
    }

    public abstract void createCalendar(List<String> appointments);
}
