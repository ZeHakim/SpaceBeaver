package org.diehl.ports;


import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractInboundPort;
import org.diehl.components.CEPBus;
import org.diehl.domain.events.EventI;
import org.diehl.interfaces.EventReceptionCI;


public class EventReceptionInboundPort extends AbstractInboundPort implements EventReceptionCI {

    private static final long serialVersionUID = 1L;

    public EventReceptionInboundPort(String uri, ComponentI owner) throws Exception {
        super(uri, EventReceptionCI.class, owner);
    }


    @Override
    public void receiveEvent(String emitterURI, String destinationURI, EventI e) throws Exception {
        this.getOwner().handleRequestSync(
                o -> ((CEPBus) o).receiveEvent(emitterURI, destinationURI, e));
    }
}
