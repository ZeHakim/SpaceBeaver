package cep.domain.events;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import static java.time.temporal.ChronoUnit.MILLIS;


public class EventBase {
	
	private ArrayList<EventI> events;
	
	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------
	public EventBase() {
		this.events = new ArrayList<EventI>();
	}
	
	
	/**
	 * Methode qui supprime tout les évenments de eventBase depuis maintenant - period 
	 * @param period
	 * @throws Exception	<i>to do</i>.
	 * @author hakim
	 */
	public void clearEvents(Duration period) {
		for (int i = 0; i < events.size(); i++) {
			if (MILLIS.between(LocalTime.now(), events.get(i).getTimeStamp().getTime()) <= period.toMillis()){
				events.remove(i);
			}
		}
	}
	
	/**
	 * Methode qui retourne le nombre d'évenements dans eventBase
	 * @author hakim
	 */
	public int numberOfEvents() {
		return events.size();
	}
	
	/**
	 * Methode qui retourne l'évenement à l'index i
	 * @param i
	 * @return event
	 * @author hakim
	 */
	public EventI getEvent(int i) {
		return events.get(i);
	}
	
	/**
	 * Methode qui ajoute un évenment dans eventBase
	 * @param e
	 * @throws Exception	<i>to do</i>.
	 * @author hakim
	 */
	public void addEvent(EventI e) {
		events.add(e);
	}
	
	/**
	 * Methode qui supprime un évenment dans eventBase
	 * @param e
	 * @throws Exception	<i>to do</i>.
	 * @author hakim
	 */
	public void removeEvent(EventI e) {
		events.remove(e);
		
	}
	
	/**
	 * Methode qui vérifie présence d'un évenment dans eventBase
	 * @param e
	 * @throws Exception	<i>to do</i>.
	 * @author hakim
	 */
	public boolean appearsIn(EventI e) {
		return events.contains(e);
	}

	public ArrayList<EventI> getEvents() {
		return this.events;
	}

	public void clear() {
		this.events.clear();
	}
}
