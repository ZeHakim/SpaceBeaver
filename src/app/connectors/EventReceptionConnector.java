package app.connectors;

import app.components.CEPBus;
import app.interfaces.bus.EventReceptionCI;
import app.interfaces.events.EventI;
import fr.sorbonne_u.components.connectors.AbstractConnector;

public class EventReceptionConnector extends AbstractConnector implements EventReceptionCI{

	@Override
	public void receiveEvent(String uri, EventI e) throws Exception {
		System.out.println("je suis dans le connector");
		
		((CEPBus) this.offering).receiveEvent(uri, e);
		
	}

}
