package app.ports;

import app.interfaces.components.PresenceServicesI;
import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractOutboundPort;

public class PresenceOutboundPort extends AbstractOutboundPort implements PresenceServicesI {

	/**
	 * //TODO s'occuper des uris
	 */
	private static final long serialVersionUID = -4147807448298833411L;

	public PresenceOutboundPort(String uri, ComponentI owner) throws Exception {
		super(uri, PresenceServicesI.class, owner);
		assert	uri != null ;
		assert	this.owner instanceof PresenceServicesI ;
	}

	@Override
	public void transmetDetection( boolean isSomeone) throws Exception {
		((PresenceServicesI)this.getConnector()).transmetDetection(isSomeone) ;
	}
	
	
}
