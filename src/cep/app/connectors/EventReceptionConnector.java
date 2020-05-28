package cep.app.connectors;

import cep.app.components.OldCEPBus;
import cep.interfaces.EventReceptionCI;
import cep.domain.events.EventI;
import fr.sorbonne_u.components.connectors.AbstractConnector;

public class EventReceptionConnector extends AbstractConnector implements EventReceptionCI{

	@Override
	public void receiveEvent(String uri, EventI e) throws Exception {
		System.out.println("je suis dans le connector");
		
		((OldCEPBus) this.offering).receiveEvent(uri, e);
		
	}

}
