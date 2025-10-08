package factory.challenge.test;

import factory.challenge.calendar.Calendar;
import factory.challenge.calendar.impl.PacificCalendar;
import factory.challenge.zone.factory.ZoneFactory;

import java.util.Arrays;
import java.util.List;

/**
 * @author lh
 */
public class CalendarTestDrive {
    public static void main(String[] args){
        ZoneFactory zoneFactory = new ZoneFactory();
        Calendar calendar = new PacificCalendar(zoneFactory);

        List<String> appts =   Arrays.asList("appt 1", "appt 2");
        calendar.createCalendar(appts);
        calendar.print();
    }
}
