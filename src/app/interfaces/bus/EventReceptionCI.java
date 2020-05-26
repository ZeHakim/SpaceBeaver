package app.interfaces.bus;

import fr.sorbonne_u.components.interfaces.OfferedI;
import app.interfaces.events.EventI;

public interface EventReceptionCI extends OfferedI {

	/**
	 * Methode qui permet la reception d'un event
	 * @param uri
	 * @param e
	 * @throws Exception	<i>to do</i>.
	 * @author hakim
	 */
	public void receiveEvent(String uri, EventI e) throws Exception;
}
