package cep.domain.correlators;


import cep.domain.actuators.BuildingAlarm;
import cep.domain.events.EventI;

import java.util.ArrayList;

public class IntrusionRule extends AbstractRule {

    public IntrusionRule() {
    }

    public static final EventMatcherI MATCHER_WINDOW_OPEN =
            (e -> e.getPropertyValue("type").
                    equals("window open"));
    public static final EventMatcherI MATCHER_PRESENCE_DETECTION =
            (e -> e.getPropertyValue("type").
                    equals("presence detection"));

    @Override
    public ArrayList<EventI> trigger() {
        EventI windowOpen = this.match(MATCHER_WINDOW_OPEN);
        EventI presence = this.match(MATCHER_PRESENCE_DETECTION);
        if (windowOpen.getTimeStamp().compareTo(presence.getTimeStamp()) <= 0) {
            // the event window open happened before the detection of a
            // presence, hence we suspect an intrusion.
            ArrayList<EventI> ret = new ArrayList<EventI>();
            ret.add(windowOpen);
            ret.add(presence);
            return ret;
        } else {
            // no intrusion detected.
            return null;
        }
    }

    @Override
    public void actions(ArrayList<EventI> triggeringEvents) {
        BuildingAlarm alarm = new BuildingAlarm(((String) triggeringEvents.get(0).getPropertyValue("room")),
                "intrusion detected at " + triggeringEvents.get(0).getTimeStamp().getTime());
        // emit the alarm
        alarm.execute();
    }

}

