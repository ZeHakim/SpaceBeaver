package cep.plug.ports;


import cep.interfaces.bus.CEPBusManagementCI;
import cep.plug.components.CEPBus;
import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractInboundPort;


public class CEPBusManagementInboundPort extends AbstractInboundPort implements CEPBusManagementCI {

    private static final long serialVersionUID = 1L;

    public CEPBusManagementInboundPort(String uri, ComponentI owner) throws Exception {
        super(uri, CEPBusManagementCI.class, owner);
    }


    @Override
    public String getEventReceptionInboundPortURI(String uri) throws Exception {
        return null;
    }

    @Override
    public void registerEventReceptor(String uri, String inboundPortURI) throws Exception {
        this.getOwner().handleRequestSync(
                o -> ((CEPBus) o).registerEventReceptor(uri, inboundPortURI));
    }

    @Override
    public void unregisterEventReceptor(String uri) throws Exception {

    }


    @Override
    public void registerCommandExecutor(String uri, String inboundPortURI) throws Exception {
        this.getOwner().handleRequestSync(
                o -> ((CEPBus) o).registerCommandExecutor(uri, inboundPortURI));
    }

    @Override
    public String getExecutorInboundPortURI(String excutorURI) throws Exception {
        return null;
    }

    @Override
    public void unregisterCommandExecutor(String uri) throws Exception {

    }

}
