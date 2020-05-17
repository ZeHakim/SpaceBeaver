package app.interfaces.bus;

import app.interfaces.events.EventI;
import fr.sorbonne_u.components.interfaces.OfferedI;

public interface EventReceptionCI extends OfferedI {
	
	public void sendEvent(String emitterURI, String destinationURI, EventI e) throws Exception ;
	
	public void multisendEvent(String emitterURI, String[] destinatioURI, EventI e) throws Exception ;

	public void receiveEvent(String uri, EventI e);
}
