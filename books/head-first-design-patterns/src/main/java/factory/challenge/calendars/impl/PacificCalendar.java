package factory.challenge.calendars.impl;

import factory.challenge.calendars.Calendar;
import factory.challenge.zone.factory.ZoneFactory;

import java.util.List;

/**
 * @author lh
 */
public class PacificCalendar extends Calendar {
    public PacificCalendar(ZoneFactory zoneFactory) {
        zone = zoneFactory.createZone("US/Pacific");
        // make a calendar for the pacific zone
        //...
    }

    @Override
    public void createCalendar(List<String> appointments) {
        // Make calendar from appointments
        System.out.println("Making the calendar");
    }
}
