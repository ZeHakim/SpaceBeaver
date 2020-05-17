package app.interfaces.bus;

import app.interfaces.events.EventI;
import fr.sorbonne_u.components.interfaces.OfferedI;

public interface EventReceptionCI extends OfferedI {

	public void receiveEvent(String uri, EventI e);
}
