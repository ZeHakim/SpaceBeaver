package app.components.rules;

import app.interfaces.rules.RuleI;
import app.interfaces.rules.EventMatcherI;
import app.components.events.EventBase;
import app.interfaces.events.EventI;
import java.util.ArrayList;
import app.components.events.EventBase;

/**
 * Classe r�gle de l'�clairage d'une salle, renvoit true si quelqu'un se trouve dans la piece et false sinon
 * @author Gabriel Bouchez
 *
 */
public class RuleEclairage implements RuleI {
	private EventBase events = null;
	
	public static final EventMatcherI MATCHER_PRESENCE_DETECTION =
			(e -> e.getProperty("type").equals("presence detection")) ;
	
	
	@Override
	public void init() {
	}

	@Override
	public EventI match(EventMatcherI matcher) {
		EventI res = null; 
		for (int i=0; i<events.numberOfEvents(); i++) {
			EventI nextEvent = events.getEvent(i);
			if (matcher.match(nextEvent)) {
				if () ((res!=null)  && (res.getTimeStamp().compareTo(nextEvent.getTimeStamp()) < 0) ) || (res==null) ){
					res = nextEvent;
				}
			}
		}
		return res;
	}

	@Override
	public ArrayList<EventI> trigger() {
		EventI presence = this.match(MATCHER_PRESENCE_DETECTION) ;
		if ( presence!=null) {
			//il y a une pr�sence 
			ArrayList<EventI> res = new ArrayList<EventI>() ;
			res.add(presence) ;
			return res ;
		}else {
			//il n'y en a pas
			return null;
		}
	}

	@Override
	public void actions(ArrayList<EventI> triggerringEvents) {
		//dans le corrélateur: si faux depuis plus de 10 sec --> �teindre 
		//TODO: appelle les interrupteurs d��clairage de la pi�ce pour �teindre les lumi�res.
		//emit the order
		System.out.println("there isnt anyone , maybe switch off the light ");
	}

	@Override
	public void effects(ArrayList<EventI> triggerringEvents) {
		events.removeEvent(triggerringEvents.get(0)) ;
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
