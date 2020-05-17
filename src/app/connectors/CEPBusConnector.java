package app.connectors;

import app.interfaces.bus.CEPBusManagementCI;
import app.interfaces.bus.EventEmissionCI;
import app.interfaces.bus.EventReceptionCI;
import app.interfaces.events.EventI;
import fr.sorbonne_u.components.connectors.AbstractConnector;

public class CEPBusConnector extends AbstractConnector implements CEPBusManagementCI, EventEmissionCI, EventReceptionCI {

	@Override
	public void sendEvent(String emitterURI, String destinationURI, EventI e) throws Exception {
		System.out.println("dans la bus connector");
		((EventReceptionCI)this.offering).sendEvent(emitterURI, destinationURI, e);
	}

	@Override
	public void multisendEvent(String emitterURI, String[] destinatioURI, EventI e) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void receiveEvent(String emitterURI, EventI e) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getEventReceptionInboundPortURI(String uri) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerEventReceptor(String uri, String inboundPortURI) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unregisterEventReceptor(String uri) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerCommandExecutor(String uri, String inboundPortURI) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getExecutorInboundPortURI(String excutorURI) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void unregisterCommandExecutor(String uri) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
