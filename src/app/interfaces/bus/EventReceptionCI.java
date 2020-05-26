package app.interfaces.bus;

import app.interfaces.events.EventI;
import fr.sorbonne_u.components.interfaces.OfferedI;

public interface EventReceptionCI extends OfferedI {

	
	/**
	 * Methode qui permet la reception d'vent 
	 * @param uri
	 * @param e
	 * @throws Exception	<i>to do</i>.
	 * @author hakim
	 */
	public void receiveEvent(String uri, EventI e) throws Exception;
}
