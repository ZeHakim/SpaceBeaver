package app.components.events;

import java.io.Serializable;
import java.util.ArrayList;

import app.components.interfaces.AggregateEventI;
import app.components.interfaces.EventI;

public class AggregateEvent implements AggregateEventI {

	private static final long serialVersionUID = 1L;
	private String uri;
	private TimeStamp timeStamp;
	private ArrayList<EventI> correlatedEvents;
	
	
	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------
	public AggregateEvent(String uri, ArrayList<EventI> correlatedEvents, TimeStamp timeStamp) {
		this.uri = uri;
		this.correlatedEvents = correlatedEvents;
		this.timeStamp = timeStamp;
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
	 */
	@Override
	public boolean hasProperty(String name) {
		return correlatedEvents.get(0).hasProperty(name) || correlatedEvents.get(1).hasProperty(name);
	}

	/**
	 * Methode qui retourne la property associée à l'event agrége
	 * @return property
	 * @throws Exception	<i>to do</i>.
	 * @author Hakim
	 */
	@Override
	public Serializable getProperty(String name) {
		return correlatedEvents.get(0).getProperty(name);
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
