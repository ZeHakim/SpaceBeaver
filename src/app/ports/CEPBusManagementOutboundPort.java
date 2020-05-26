package app.ports;

import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractInboundPort;
import fr.sorbonne_u.components.ports.AbstractOutboundPort;

import app.components.CEPBus;
import app.interfaces.bus.CEPBusManagementCI;
import app.interfaces.bus.EventEmissionCI;
import app.interfaces.bus.EventReceptionCI;
import app.interfaces.events.EventI;

// TODO vérifier si cette class sert à qq chose
public class CEPBusManagementOutboundPort extends AbstractOutboundPort implements CEPBusManagementCI {
	private static final long serialVersionUID = 1L;

	public CEPBusManagementOutboundPort(ComponentI owner) throws Exception {
		super(CEPBusManagementCI.class, owner);
	}

	public CEPBusManagementOutboundPort(String uri, ComponentI owner) throws Exception {
		super(uri, CEPBusManagementCI.class, owner);
	}

	protected CEPBusManagementOutboundPort(Class<?> implementedInterface, ComponentI owner)	throws Exception {
		super(implementedInterface, owner);
	}

	protected CEPBusManagementOutboundPort(String uri, Class<?> implementedInterface, ComponentI owner)	throws Exception {
		super(uri, implementedInterface, owner);
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
