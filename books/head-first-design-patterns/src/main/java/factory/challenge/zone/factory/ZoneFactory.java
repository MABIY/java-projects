package factory.challenge.zone.factory;

import factory.challenge.zone.Zone;
import factory.challenge.zone.impl.ZoneCentral;
import factory.challenge.zone.impl.ZoneEastern;
import factory.challenge.zone.impl.ZoneMountain;
import factory.challenge.zone.impl.ZonePacific;

/**
 * @author lh
 */
public class ZoneFactory {
    public  Zone createZone(String zondId){
        if(zondId==null){
            return null;
        }

        switch (zondId){
            case "US/Pacific":
               return new ZonePacific();
            case "US/Mountain":
                return new ZoneMountain();
            case "US/Central":
                return new ZoneCentral();
            case "US/Eastern":
                return new ZoneEastern();
            default:
                throw new RuntimeException("not support zoneId:" + zondId);
        }
    }
}
