package cep.domain.correlators;


import cep.domain.actuators.BuildingAlarm;
import cep.domain.events.EventBase;
import cep.domain.events.EventI;

import java.util.ArrayList;

public class IntrusionRule implements RuleI {

    private EventBase eventBase;

    public IntrusionRule() {
    }

    public static final EventMatcherI MATCHER_WINDOW_OPEN =
            (e -> e.getPropertyValue("type").
                    equals("window open"));
    public static final EventMatcherI MATCHER_PRESENCE_DETECTION =
            (e -> e.getPropertyValue("type").
                    equals("presence detection"));

    @Override
    public RuleI clone() {
        return null;
    }


    @Override
    public EventI match(EventMatcherI matcher) {
        return this.eventBase.getEvents().stream().filter(matcher::match).findFirst().orElse(null);
    }

    @Override
    public void init() {

    }

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

    @Override
    public void effects(ArrayList<EventI> triggeringEvents) {
        this.eventBase.removeEvent(triggeringEvents.get(0));
        this.eventBase.removeEvent(triggeringEvents.get(1));
    }

    @Override
    public boolean executeOn(EventBase events) {
        ArrayList<EventI> eventIS = this.trigger();
        if (eventIS != null) {
            this.actions(eventIS);
            this.effects(eventIS);
        }
        return true;
    }
}

