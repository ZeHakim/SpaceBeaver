package app.interfaces.components;

import app.interfaces.events.EventI;

public interface EventReceptionI {

	public void receiveEvent(String emitteurURI, EventI e) throws Exception ;
}
