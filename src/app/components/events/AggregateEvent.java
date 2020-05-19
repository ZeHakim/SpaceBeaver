package app.components.events;

import java.io.Serializable;
import java.util.ArrayList;

import app.interfaces.events.AggregateEventI;
import app.interfaces.events.EventI;

public class AggregateEvent implements AggregateEventI {

	private static final long serialVersionUID = 1L;
	private String uri;
	private TimeStamp timeStamp;
	private ArrayList<EventI> correlatedEvents;
	
	
	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------
	public AggregateEvent(String uri, ArrayList<EventI> correlatedEvents) {
		this.uri = uri;
		this.correlatedEvents = correlatedEvents;
		this.timeStamp = new TimeStamp();
	}

	/**
	 * Methode qui retourne l'uri d l'event agrégé
	 * @return uri
	 * @throws Exception	<i>to do</i>.
	 * @author Hakim
	 */
	@Override
	public String getURI() {
		return uri;
	}

	/**
	 * Methode qui retourne l'instance de TimeStamp associé à l'event agrége
	 * @return timeStamp
	 * @throws Exception	<i>to do</i>.
	 * @author Hakim
	 */
	@Override
	public TimeStamp getTimeStamp() {
		return timeStamp;
	}

	/**
	 * Methode qui check la property associée à l'event agrége
	 * @return boolean
	 * @throws Exception	<i>to do</i>.
	 * @author Hakim
	 * @return 
	 */
	@Override
	public boolean hasProperty(String name) {
		for (int i=0; i < correlatedEvents.size(); i++) {
			if (correlatedEvents.get(i).hasProperty(name)) return true;
		}
		return false;
	}

	/**
	 * Methode qui retourne la property associée à l'event agrége
	 * @return property
	 * @throws Exception	<i>to do</i>.
	 * @author Hakim
	 */
	@Override
	public Serializable getProperty(String name) {
		for (int i=0; i < correlatedEvents.size(); i++) {
			if (correlatedEvents.get(i).hasProperty(name)) return correlatedEvents.get(i).getProperty(name);
		}
		return null;
	}

	/**
	 * Methode qui retourne la liste des events qui composent l'event agrége
	 * @return correlatedEvent
	 * @throws Exception	<i>to do</i>.
	 * @author Hakim
	 */
	@Override
	public ArrayList<EventI> getCorrelatedEvents() {
		return correlatedEvents;
	}

}
