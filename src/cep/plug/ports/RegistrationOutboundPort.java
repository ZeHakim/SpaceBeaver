package cep.plug.ports;

import cep.interfaces.bus.CEPBusManagementCI;
import cep.interfaces.bus.EventEmissionCI;
import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractOutboundPort;


public class RegistrationOutboundPort extends AbstractOutboundPort implements CEPBusManagementCI {

    private static final long serialVersionUID = 1L;

    public RegistrationOutboundPort(String uri, ComponentI owner) throws Exception {
        super(uri, EventEmissionCI.class, owner);
    }

    public RegistrationOutboundPort(ComponentI owner) throws Exception {
        super(EventEmissionCI.class, owner);
    }

    @Override
    public String getEventReceptionInboundPortURI(String uri) throws Exception {
        return null;
    }

    @Override
    public void registerEventReceptor(String uri, String inboundPortURI) throws Exception {
        ((CEPBusManagementCI) this.connector).registerEventReceptor(uri, inboundPortURI);
    }

    @Override
    public void unregisterEventReceptor(String uri) throws Exception {

    }

    @Override
    public void registerCommandExecutor(String uri, String inboundPortURI) throws Exception {
        ((CEPBusManagementCI) this.connector).registerCommandExecutor(uri, inboundPortURI);
    }

    @Override
    public String getExecutorInboundPortURI(String excutorURI) throws Exception {
        return null;
    }

    @Override
    public void unregisterCommandExecutor(String uri) throws Exception {

    }
}
