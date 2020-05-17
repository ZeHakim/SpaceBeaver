package app.ports;

import app.components.CEPBus;
import app.interfaces.bus.CEPBusManagementCI;
import app.interfaces.bus.EventEmissionCI;
import app.interfaces.bus.EventReceptionCI;
import app.interfaces.events.EventI;
import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractInboundPort;
import fr.sorbonne_u.components.ports.AbstractOutboundPort;


public class CEPBusOutboundPort extends AbstractOutboundPort implements CEPBusManagementCI, EventEmissionCI{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CEPBusOutboundPort(ComponentI owner) throws Exception {
		super(EventEmissionCI.class, owner);
	}

	public CEPBusOutboundPort(String uri, ComponentI owner) throws Exception {
		super(uri, EventEmissionCI.class, owner);
	}

	protected CEPBusOutboundPort(Class<?> implementedInterface, ComponentI owner)
			throws Exception {
		super(implementedInterface, owner);
	}

	protected CEPBusOutboundPort(String uri, Class<?> implementedInterface, ComponentI owner)
			throws Exception {
		super(uri, implementedInterface, owner);
	}
	
	
	@Override
	public void sendEvent(String emitterURI, String destinationURI, EventI e) throws Exception {
		((EventEmissionCI) this.connector).sendEvent(emitterURI, destinationURI, e);
	}

	@Override
	public void multiSendEvent(String emitterURI, String[] destinationURIs, EventI e) throws Exception {
		((EventEmissionCI) this.connector).multiSendEvent(emitterURI, destinationURIs, e);
		
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
