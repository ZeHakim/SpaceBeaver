package app.connectors;

import app.components.CEPBus;
import app.interfaces.bus.EventEmissionCI;
import app.interfaces.bus.EventReceptionCI;
import app.interfaces.events.EventI;
import app.ports.EventReceptionInboundPort;
import fr.sorbonne_u.components.connectors.AbstractConnector;

public class EventEmissionConnector extends AbstractConnector implements EventEmissionCI{

	@Override
	public void sendEvent(String emitterURI, String destinationURI, EventI e) throws Exception {
		System.out.println("je suis dans le connector eventEmission");
		((EventReceptionInboundPort)this.offering).receiveEvent(emitterURI, e);;
		//((EventReceptionCI)this.offering).sendEvent(emitterURI, destinationURI, e);
		
	}

	@Override
	public void multiSendEvent(String emitterURI, String[] destinationURIs, EventI e) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
