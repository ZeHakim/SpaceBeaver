package app.ports;

import app.components.CEPBus;
import app.interfaces.bus.CEPBusManagementCI;
import app.interfaces.bus.EventReceptionCI;
import app.interfaces.events.EventI;
import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractInboundPort;
import fr.sorbonne_u.components.ports.AbstractOutboundPort;


public class CEPBusOutboundPort extends AbstractOutboundPort implements CEPBusManagementCI, EventReceptionCI{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CEPBusOutboundPort(ComponentI owner) throws Exception {
		super(EventReceptionCI.class, owner);
		System.out.println("Constrructeur 1");
		assert owner instanceof CEPBus;
	}

	public CEPBusOutboundPort(String uri, ComponentI owner) throws Exception {
		super(uri, EventReceptionCI.class, owner);
		System.out.println("Constrructeur 2");
		assert owner instanceof CEPBus;
	}

	protected CEPBusOutboundPort(Class<?> implementedInterface, ComponentI owner)
			throws Exception {
		super(implementedInterface, owner);
		System.out.println("Constrructeur 3");
		assert owner instanceof CEPBus;
	}

	protected CEPBusOutboundPort(String uri, Class<?> implementedInterface, ComponentI owner)
			throws Exception {
		super(uri, implementedInterface, owner);
		System.out.println("Constrructeur 4");
		assert owner instanceof CEPBus;
	}
	

	@Override
	public void sendEvent(String emitterURI, String destinationURI, EventI e) throws Exception {
		((EventReceptionCI) this.connector).sendEvent(emitterURI, destinationURI, e);
	}

	@Override
	public void multisendEvent(String emitterURI, String[] destinatioURI, EventI e) throws Exception {
		System.out.println("send message dans busOutPort");
		((EventReceptionCI) this.connector).multisendEvent(emitterURI, destinatioURI, e);
		
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
