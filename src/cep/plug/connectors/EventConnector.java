package cep.plug.connectors;

import cep.interfaces.EventEmissionCI;
import cep.interfaces.EventReceptionCI;
import cep.domain.events.EventI;
import fr.sorbonne_u.components.connectors.AbstractConnector;

public class EventConnector extends AbstractConnector implements EventEmissionCI {

    @Override
    public void sendEvent(String emitterURI, String destinationURI, EventI e) throws Exception {
        ((EventReceptionCI) this.offering).receiveEvent(emitterURI, e);
    }

    @Override
    public void multiSendEvent(String emitterURI, String[] destinationURIs, EventI e) throws Exception {

    }
}
