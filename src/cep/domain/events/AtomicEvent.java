package cep.domain.events;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class AtomicEvent implements AtomicEventI{

	private static final long serialVersionUID = 1L;
	private String uri;
	private TimeStamp timeStamp;
	private Map <String, Serializable> properties;
	
	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------
	public AtomicEvent(String uri) {
		this.uri = uri;
		this.timeStamp = new TimeStamp();
		properties = new HashMap<>();
	}

	public AtomicEvent() {
		this.uri = UUID.randomUUID().toString();
		this.timeStamp = new TimeStamp();
		this.properties = new ConcurrentHashMap<>();
	}
	
	/**
	 * Methode qui retourne l'uri d l'event
	 * @return uri
	 * @throws Exception	<i>to do</i>.
	 */
	@Override
	public String getURI() {
		return uri;
	}
	
	/**
	 * Methode qui retourne l'instance de TimeStamp associé à l'event
	 * @return timeStamp
	 * @throws Exception	<i>to do</i>.
	 */
	@Override
	public TimeStamp getTimeStamp() {
		return timeStamp;
	}

	/**
	 * Methode qui check si l'event posséd une property
	 * @return boolean
	 * @throws Exception	<i>to do</i>.
	 */
	@Override
	public boolean hasProperty(String name) {
		return properties.containsKey(name);
	}

	/**
	 * Methode qui retourne la property associée à l'event
	 * @return result
	 * @throws Exception	<i>to do</i>.
	 * @author Hakim
	 */
	@Override
	public Serializable getPropertyValue(String name) {
		return properties.get(name);
	}

	/**
	 * Methode qui ajoute une property à l'event
	 * @return result
	 * @throws Exception	<i>to do</i>.
	 * @author Hakim
	 */
	@Override
	public Serializable putProperty(String name, Serializable value) {
		return properties.put(name, value);
	}

	/**
	 * Methode qui supprime une property à l'event
	 * @return result
	 * @throws Exception	<i>to do</i>.
	 * @author Hakim
	 */
	@Override
	public Serializable removeProperty(String name) {
		return properties.remove(name);
	}

}
