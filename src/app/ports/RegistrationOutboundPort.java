package org.diehl.ports;

import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractOutboundPort;
import org.diehl.interfaces.CEPBusManagementCI;
import org.diehl.interfaces.EventEmissionCI;


public class RegistrationOutboundPort extends AbstractOutboundPort implements CEPBusManagementCI {

    private static final long serialVersionUID = 1L;

    public RegistrationOutboundPort(String uri, ComponentI owner) throws Exception {
        super(uri, EventEmissionCI.class, owner);
    }

    public RegistrationOutboundPort(ComponentI owner) throws Exception {
        super(EventEmissionCI.class, owner);
    }

    @Override
    public void registerEventReceptor(String uri, String inboundPortURI) throws Exception {
        ((CEPBusManagementCI) this.connector).registerEventReceptor(uri, inboundPortURI);
    }

    @Override
    public void registerCommandExecutor(String uri, String inboundPortURI) throws Exception {
        ((CEPBusManagementCI) this.connector).registerCommandExecutor(uri, inboundPortURI);
    }
}
