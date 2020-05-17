package app.components.rules;

import app.interfaces.rules.RuleI;
import app.interfaces.rules.EventMatcherI;
import app.components.events.EventBase;
import app.interfaces.events.EventI;
import java.util.ArrayList;

public class RuleEclairage implements RuleI {
	private EventBase events = null;

	public static final EventMatcherI MATCHER_PRESENCE_DETECTION = (e -> e.getProperty("type")
			.equals("presence detection"));

	public static final EventMatcherI MATCHER_LIGHT_ON_DETECTION = (e -> e.getProperty("type")
			.equals("light on detection"));

	@Override
	public void init() {
	}

	@Override
	public EventI match(EventMatcherI matcher) {
		EventI res = null; 
		for (int i = 0; i < events.numberOfEvents(); i++) {
			EventI nextEvent = events.getEvent(i);
			if (matcher.match(nextEvent)) {
				if ((res != null) && (res.getTimeStamp().compareTo(nextEvent.getTimeStamp()) < 0)) {
					res = nextEvent;
				}
			}
		}
		return res;
	}

	@Override
	public ArrayList<EventI> trigger() {
		EventI lightOn = this.match(MATCHER_LIGHT_ON_DETECTION);
		EventI presence = this.match(MATCHER_PRESENCE_DETECTION);
		if (lightOn != null && presence == null) {
			// lumiere allum� et aucune pr�sence
			ArrayList<EventI> res = new ArrayList<EventI>();
			res.add(lightOn);
			return res;
		} else {
			// autres cas
			return null;
		}
	}

	@Override
	public void actions(ArrayList<EventI> triggerringEvents) {
		// TODO: appelle les interrupteurs d'éclairage de la pièce pour éteindre les
		// lumières.
		// emit the order
		System.out.println("switch off the light ");
	}

	@Override
	public void effects(ArrayList<EventI> triggerringEvents) {
		events.removeEvent(triggerringEvents.get(0));
		events.removeEvent(triggerringEvents.get(1));
	}

	@Override
	public boolean executeOn(EventBase base) {
		events = base;
		ArrayList<EventI> eventsTeste = trigger();
		if (eventsTeste != null) {
			actions(eventsTeste);
			effects(eventsTeste);
			return true;
		} else {
			return false;
		}

	}
}
