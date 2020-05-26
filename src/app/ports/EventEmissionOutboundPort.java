package org.diehl.ports;

import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractOutboundPort;
import org.diehl.domain.events.EventI;
import org.diehl.interfaces.EventEmissionCI;


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
}
