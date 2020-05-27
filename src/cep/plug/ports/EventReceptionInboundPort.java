package cep.plug.ports;


import cep.interfaces.bus.EventReceptionCI;
import cep.domain.events.EventI;
import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractInboundPort;
import cep.plug.components.CEPBus;


public class EventReceptionInboundPort extends AbstractInboundPort implements EventReceptionCI {

    private static final long serialVersionUID = 1L;

    public EventReceptionInboundPort(String uri, ComponentI owner) throws Exception {
        super(uri, EventReceptionCI.class, owner);
    }


    @Override
    public void receiveEvent(String emitterURI, EventI e) throws Exception {
        this.getOwner().handleRequestSync(
                o -> ((CEPBus) o).receiveEvent(emitterURI, e));
    }
}
