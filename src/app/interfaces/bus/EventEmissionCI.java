package app.interfaces.bus;

import app.interfaces.events.EventI;
import fr.sorbonne_u.components.interfaces.RequiredI;

public interface EventEmissionCI extends RequiredI {
	
	public void receiveEvent(String emitterURI, EventI e) throws Exception ;

	public void sendEvent(String emitterURI, String destinationURI, EventI e);
	
	public void multiSendEvent(String emitterURI, String[] destinationURIs, EventI e);
}
