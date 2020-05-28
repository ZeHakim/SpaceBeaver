package cep.app.ports;

import cep.interfaces.EventEmissionCI;
import cep.domain.events.EventI;
import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractOutboundPort;

public class EventEmissionOutboundPort extends AbstractOutboundPort implements EventEmissionCI{
	
	
	private static final long serialVersionUID = 1L;

	public EventEmissionOutboundPort(ComponentI owner) throws Exception {
		super(EventEmissionCI.class, owner);
	}

	public EventEmissionOutboundPort(String uri, ComponentI owner) throws Exception {
		super(uri, EventEmissionCI.class, owner);
	}

	protected EventEmissionOutboundPort(Class<?> implementedInterface, ComponentI owner)
			throws Exception {
		super(implementedInterface, owner);
	}

	protected EventEmissionOutboundPort(String uri, Class<?> implementedInterface, ComponentI owner)
			throws Exception {
		super(uri, implementedInterface, owner);
	}
	
	/**
	 * Methode qui permet l'envoie d'vent a des destinations
	 * @param emitterURI
	 * @param destinationURI
	 * @throws Exception	<i>to do</i>.
	 * @author hakim
	 *
	 */
	@Override
	public void sendEvent(String emitterURI, String destinationURI, EventI e) throws Exception {
		System.out.println("je suis dans le port sortant !!!!!");
		((EventEmissionCI) this.connector).sendEvent(emitterURI, destinationURI, e);
	}

	/**
	 * Methode qui permet l'envoie d'vent a des destinations
	 * @param emitterURI
	 * @param destinationURIs
	 * @throws Exception	<i>to do</i>.
	 * @author hakim
	 */
	@Override
	public void multiSendEvent(String emitterURI, String[] destinationURIs, EventI e) throws Exception {
		((EventEmissionCI) this.connector).multiSendEvent(emitterURI, destinationURIs, e);
		
	}

}
