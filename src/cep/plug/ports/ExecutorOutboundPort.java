package cep.plug.ports;

import cep.interfaces.ExecutorCI;
import cep.domain.correlators.ExecutorCommandI;
import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractOutboundPort;

public class ExecutorOutboundPort extends AbstractOutboundPort implements ExecutorCI {

    private static final long serialVersionUID = 1L;


    public ExecutorOutboundPort(String uri, ComponentI owner) throws Exception {
        super(uri, ExecutorCI.class, owner);
    }


    @Override
    public void execute(ExecutorCommandI command) throws Exception {
        ((ExecutorCI) this.connector).execute(command);
    }
}
