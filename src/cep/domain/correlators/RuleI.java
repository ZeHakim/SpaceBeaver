package cep.domain.correlators;

import cep.domain.events.EventBase;
import cep.domain.events.EventI;

import java.util.ArrayList;

public interface RuleI {

     EventI match(EventMatcherI matcher);

    void init();

    ArrayList<EventI> trigger();

    void actions(ArrayList<EventI> triggeringEvents);

    void effects(ArrayList<EventI> triggeringEvents);

    boolean executeOn(EventBase events);
}
