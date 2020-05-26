package app.interfaces.bus;

import fr.sorbonne_u.components.interfaces.RequiredI;
import app.interfaces.events.EventI;

public interface EventEmissionCI extends RequiredI {

	/**
	 * Methode qui permet l'envoie d'un event a une destination
	 * @param emitterURI
	 * @param destinationURI
	 * @throws Exception	<i>to do</i>.
	 * @author hakim
	 */
	public void sendEvent(String emitterURI, String destinationURI, EventI e) throws Exception;

	/**
	 * Methode qui permet l'envoie d'un event a plusieurs destinations
	 * @param emitterURI
	 * @param destinationURIs
	 * @throws Exception	<i>to do</i>.
	 * @author hakim
	 */
	public void multiSendEvent(String emitterURI, String[] destinationURIs, EventI e) throws Exception;
}
