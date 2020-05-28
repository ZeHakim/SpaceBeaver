package cep.plug.ports;

import cep.interfaces.EventEmissionCI;
import cep.domain.events.EventI;
import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractOutboundPort;


public class EventEmissionOutboundPort extends AbstractOutboundPort implements EventEmissionCI {

    private static final long serialVersionUID = 1L;


    public EventEmissionOutboundPort(String uri, ComponentI owner) throws Exception {
        super(uri, EventEmissionCI.class, owner);
    }

    public EventEmissionOutboundPort(ComponentI owner) throws Exception {
        super(EventEmissionCI.class, owner);
    }

    @Override
    public void sendEvent(String emitterURI, String destinationURI, EventI e) throws Exception {
        ((EventEmissionCI) this.connector).sendEvent(emitterURI, destinationURI, e);
    }

    @Override
    public void multiSendEvent(String emitterURI, String[] destinationURIs, EventI e)  {

    }
}
