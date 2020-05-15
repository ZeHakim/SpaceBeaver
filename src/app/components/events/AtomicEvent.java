package app.components.events;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import app.components.interfaces.AtomicEventI;

public class AtomicEvent implements AtomicEventI{

	private static final long serialVersionUID = 1L;
	private String uri;
	private TimeStamp timeStamp;
	private Map <String, Serializable> property;
	
	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------
	public AtomicEvent(String uri, TimeStamp time) {
		this.uri = uri;
		this.timeStamp = time;
		property = new HashMap<>();
	}
	
	/**
	 * Methode qui retourne l'uri d l'event
	 * @return uri
	 * @throws Exception	<i>to do</i>.
	 * @author Hakim
	 */
	@Override
	public String getURI() {
		return uri;
	}
	
	/**
	 * Methode qui retourne l'instance de TimeStamp associé à l'event
	 * @return timeStamp
	 * @throws Exception	<i>to do</i>.
	 * @author Hakim
	 */
	@Override
	public TimeStamp getTimeStamp() {
		return timeStamp;
	}

	/**
	 * Methode qui check si l'event posséd une property
	 * @return boolean
	 * @throws Exception	<i>to do</i>.
	 * @author Hakim
	 */
	@Override
	public boolean hasProperty(String name) {
		return property.containsValue(name);
	}

	/**
	 * Methode qui retourne la property associée à l'event
	 * @return result
	 * @throws Exception	<i>to do</i>.
	 * @author Hakim
	 */
	@Override
	public Serializable getProperty(String name) {
		return property.get(name);
	}

	/**
	 * Methode qui ajoute une property à l'event
	 * @return result
	 * @throws Exception	<i>to do</i>.
	 * @author Hakim
	 */
	@Override
	public Serializable putProperty(String name, Serializable value) {
		return property.put(name, value);
	}

	/**
	 * Methode qui supprime une property à l'event
	 * @return result
	 * @throws Exception	<i>to do</i>.
	 * @author Hakim
	 */
	@Override
	public Serializable removeProperty(String name) {
		// TODO Auto-generated method stub
		return property.remove(name);
	}

}
