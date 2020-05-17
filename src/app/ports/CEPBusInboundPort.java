package app.ports;

import app.components.CEPBus;
import app.interfaces.bus.CEPBusManagementCI;
import app.interfaces.bus.EventEmissionCI;
import app.interfaces.events.EventI;
import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractInboundPort;


public class CEPBusInboundPort extends AbstractInboundPort implements CEPBusManagementCI, EventEmissionCI{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CEPBusInboundPort(ComponentI owner) throws Exception {
		super(CEPBusManagementCI.class, owner);
		assert owner instanceof CEPBus;
	}

	public CEPBusInboundPort(String uri, ComponentI owner) throws Exception {
		super(uri, CEPBusManagementCI.class, owner);
		assert owner instanceof CEPBus;
	}

	protected CEPBusInboundPort(Class<?> implementedInterface, ComponentI owner)
			throws Exception {
		super(implementedInterface, owner);
		assert owner instanceof CEPBus;
	}

	protected CEPBusInboundPort(String uri, Class<?> implementedInterface, ComponentI owner)
			throws Exception {
		super(uri, implementedInterface, owner);
		assert owner instanceof CEPBus;
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
