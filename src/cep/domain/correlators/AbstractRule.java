package cep.domain.correlators;

import cep.domain.events.EventBase;
import cep.domain.events.EventI;

import java.util.ArrayList;

public abstract class AbstractRule implements RuleI, ExecutorCommandI {

    private EventBase eventBase;

    public EventBase getEventBase() {
        return eventBase;
    }

    public void setEventBase(EventBase eventBase) {
        this.eventBase = eventBase;
    }

    @Override
    public EventI match(EventMatcherI matcher) {
        return this.eventBase.getEvents().stream().filter(matcher::match).findFirst().orElse(null);
    }

    @Override
    public void init() {

    }

    @Override
    public void actions(ArrayList<EventI> triggeringEvents) {

    }

    @Override
    public void effects(ArrayList<EventI> triggeringEvents) {
        triggeringEvents.forEach(eventI -> this.getEventBase().removeEvent(eventI));
    }

    @Override
    public boolean executeOn(EventBase eventBase) {
        ArrayList<EventI> eventIS = this.trigger();
        if (eventIS != null) {
            this.actions(eventIS);
            this.effects(eventIS);
        }
        return true;
    }
}
