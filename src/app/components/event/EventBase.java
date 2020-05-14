package app.components.event;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;

import app.components.event.interfaces.EventI;


public class EventBase {
	
	private ArrayList<EventI> eventBase;
	

	public EventBase() {
		this.eventBase = new ArrayList<EventI>();
	}
	
	
	/**
	 * Methode qui supprime tout les évenments de eventBase depuis maintenant - period 
	 * @param period
	 * @throws Exception	<i>to do</i>.
	 * @author hakim
	 */
	public void clearEvents(Duration period) {
		eventBase.forEach(e -> {
			//if (period.compareTo(LocalTime.now().compareTo(e.getTimeStamp().getTime()))) 
		});
	}
	
	/**
	 * Methode qui retourne le nombre d'évenements dans eventBase
	 * @author hakim
	 */
	public int numberOfEvents() {
		return eventBase.size();
	}
	
	/**
	 * Methode qui retourne l'évenement à l'index i
	 * @param i
	 * @return event
	 * @author hakim
	 */
	public EventI getEvent(int i) {
		return eventBase.get(i);
	}
	
	/**
	 * Methode qui ajoute un évenment dans eventBase
	 * @param e
	 * @throws Exception	<i>to do</i>.
	 * @author hakim
	 */
	public void addEvent(EventI e) {
		eventBase.add(e);
	}
	
	/**
	 * Methode qui supprime un évenment dans eventBase
	 * @param e
	 * @throws Exception	<i>to do</i>.
	 * @author hakim
	 */
	public void removeEvent(EventI e) {
		eventBase.remove(e);
		
	}
	
	/**
	 * Methode qui vérifie présence d'un évenment dans eventBase
	 * @param e
	 * @throws Exception	<i>to do</i>.
	 * @author hakim
	 */
	public boolean appearsIn(EventI e) {
		return eventBase.contains(e);
	}

}
