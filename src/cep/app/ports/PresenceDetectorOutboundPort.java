package cep.app.ports;

import cep.interfaces.components.PresenceDetectorCI;
import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractOutboundPort;

public class PresenceDetectorOutboundPort extends AbstractOutboundPort implements PresenceDetectorCI {
	
	private static final long serialVersionUID = 1L;

	public PresenceDetectorOutboundPort(ComponentI owner) throws Exception {
		super(PresenceDetectorCI.class, owner);
	}

	public PresenceDetectorOutboundPort(String uri, ComponentI owner) throws Exception {
		super(uri, PresenceDetectorCI.class, owner);
	}

	protected PresenceDetectorOutboundPort(Class<?> implementedInterface, ComponentI owner)
			throws Exception {
		super(implementedInterface, owner);
	}

	protected PresenceDetectorOutboundPort(String uri, Class<?> implementedInterface, ComponentI owner)
			throws Exception {
		super(uri, implementedInterface, owner);
	}

	@Override
	public void emitDetectionEvent() throws Exception {
		((PresenceDetectorCI) this.connector).emitDetectionEvent();
	}

	@Override
	public void registration() throws Exception {
		((PresenceDetectorCI) this.connector).registration();
		
	}

}
