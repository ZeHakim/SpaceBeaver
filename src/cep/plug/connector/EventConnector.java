package cep.plug.connector;

import cep.interfaces.bus.CEPBusManagementCI;
import cep.interfaces.bus.EventEmissionCI;
import cep.interfaces.bus.EventReceptionCI;
import cep.domain.events.EventI;
import fr.sorbonne_u.components.connectors.AbstractConnector;

public class EventConnector extends AbstractConnector implements EventEmissionCI, CEPBusManagementCI {

    @Override
    public void sendEvent(String emitterURI, String destinationURI, EventI e) throws Exception {
        ((EventReceptionCI) this.offering).receiveEvent(emitterURI, e);
    }

    @Override
    public void multiSendEvent(String emitterURI, String[] destinationURIs, EventI e) throws Exception {

    }

    @Override
    public String getEventReceptionInboundPortURI(String uri) throws Exception {
        return null;
    }

    @Override
    public void registerEventReceptor(String uri, String inboundPortURI) throws Exception {
        ((CEPBusManagementCI) this.offering).registerEventReceptor(uri, inboundPortURI);
    }

    @Override
    public void unregisterEventReceptor(String uri) throws Exception {

    }

    @Override
    public void registerCommandExecutor(String uri, String inboundPortURI) throws Exception {
        ((CEPBusManagementCI) this.offering).registerCommandExecutor(uri, inboundPortURI);
    }

    @Override
    public String getExecutorInboundPortURI(String excutorURI) throws Exception {
        return null;
    }

    @Override
    public void unregisterCommandExecutor(String uri) throws Exception {

    }
}
