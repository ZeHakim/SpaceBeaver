package cep.plug.ports;

import cep.domain.events.EventI;
import cep.interfaces.EventReceptionCI;
import cep.plug.components.EventReceptor;
import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractInboundPort;


public class EventReceptionInboundPort<P extends EventReceptor>
        extends AbstractInboundPort implements EventReceptionCI {

    private static final long serialVersionUID = 1L;

    public EventReceptionInboundPort(String uri, ComponentI owner) throws Exception {
        super(uri, EventReceptionCI.class, owner);
    }

    @Override
    public void receiveEvent(String emitterURI, EventI e) throws Exception {
        this.getOwner().handleRequestSync(o -> {
            ((P) o).saveEvent(emitterURI, e);
            return true;
        });
    }
}
