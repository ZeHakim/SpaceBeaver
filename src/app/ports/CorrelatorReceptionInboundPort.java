package app.ports;

import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractInboundPort;

import app.interfaces.bus.EventReceptionCI;
import app.interfaces.events.EventI;

// TODO fix imports
import org.diehl.components.ThermostatCorrelator;
import org.diehl.domain.events.EventI;
import org.diehl.interfaces.EventReceptionCI;

public class CorrelatorReceptionInboundPort extends AbstractInboundPort implements EventReceptionCI {
    private static final long serialVersionUID = 1L;

    public CorrelatorReceptionInboundPort(String uri, ComponentI owner) throws Exception {
        super(uri, EventReceptionCI.class, owner);
    }

    @Override
    public void receiveEvent(String emitterURI, String destinationURI, EventI e) throws Exception {
        this.getOwner().handleRequestSync(
                o -> ((ThermostatCorrelator) o).receiveEvent(emitterURI, destinationURI, e));
    }

	@Override
	public void receiveEvent(String uri, EventI e) throws Exception {
		this.getOwner().handleRequestSync(
                o -> ((ThermostatCorrelator) o).receiveEvent(emitterURI, destinationURI, e));
	}
}
