package cep.app.components.rules;

import cep.domain.correlators.RuleI;
import cep.domain.correlators.EventMatcherI;
import cep.domain.events.EventBase;
import cep.domain.events.EventI;
import java.util.ArrayList;

/**
 * Classe règle de l'éclairage d'une salle, renvoit true si quelqu'un se trouve
 * dans la piece et false sinon
 * 
 * @author Gabriel Bouchez
 *
 */
public class RuleEclairage implements RuleI {
	private EventBase events = null;

	public static final EventMatcherI MATCHER_PRESENCE_DETECTION = (e -> e.getPropertyValue("type")
			.equals("presence detection"));

	@Override
	public void init() {
	}

	@Override
	public EventI match(EventMatcherI matcher) {
		EventI res = null;
		for (int i = 0; i < events.numberOfEvents(); i++) {
			EventI nextEvent = events.getEvent(i);
			if (matcher.match(nextEvent)) {
				if ((res != null) && (res.getTimeStamp().compareTo(nextEvent.getTimeStamp()) < 0) || (res == null)) {
					res = nextEvent;
				}
			}
		}
		return res;
	}

	@Override
	public ArrayList<EventI> trigger() {
		EventI presence = this.match(MATCHER_PRESENCE_DETECTION);
		if (presence != null) {
			// il y a une présence
			ArrayList<EventI> res = new ArrayList<EventI>();
			res.add(presence);
			return res;
		} else {
			// il n'y en a pas
			return null;
		}
	}

	@Override
	public void actions(ArrayList<EventI> triggerringEvents) {
		// dans le corrélateur: si faux depuis plus de 10 sec --> éteindre
		// TODO: appelle les interrupteurs d��clairage de la pièce pour éteindre les
		// lumières.
		// emit the order
		System.out.println("there isnt anyone , maybe switch off the light ");
	}

	@Override
	public void effects(ArrayList<EventI> triggerringEvents) {
		events.removeEvent(triggerringEvents.get(0));
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
