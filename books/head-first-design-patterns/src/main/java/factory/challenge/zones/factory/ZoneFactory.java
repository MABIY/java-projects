package factory.challenge.zones.factory;

import factory.challenge.zones.Zone;
import factory.challenge.zones.impl.ZoneCentral;
import factory.challenge.zones.impl.ZoneEastern;
import factory.challenge.zones.impl.ZoneMountain;
import factory.challenge.zones.impl.ZonePacific;

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
