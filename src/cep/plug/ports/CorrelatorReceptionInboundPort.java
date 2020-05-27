package cep.plug.ports;

import cep.interfaces.bus.EventReceptionCI;
import cep.domain.events.EventI;
import cep.plug.components.ThermostatCorrelator;
import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractInboundPort;

public class CorrelatorReceptionInboundPort extends AbstractInboundPort implements EventReceptionCI {

    private static final long serialVersionUID = 1L;

    public CorrelatorReceptionInboundPort(String uri, ComponentI owner) throws Exception {
        super(uri, EventReceptionCI.class, owner);
    }


    @Override
    public void receiveEvent(String emitterURI, EventI e) throws Exception {
        this.getOwner().handleRequestSync(
                o -> ((ThermostatCorrelator) o).receiveEvent(emitterURI, e));
    }
}
