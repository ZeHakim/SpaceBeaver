package cep.plug.connectors;

import cep.interfaces.CEPBusManagementCI;
import fr.sorbonne_u.components.connectors.AbstractConnector;

public class RegistrationConnector extends AbstractConnector implements CEPBusManagementCI {


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
