package cep.app.components;

import cep.interfaces.CEPBusManagementCI;
import cep.interfaces.EventEmissionCI;
import cep.interfaces.EventReceptionCI;
import cep.domain.events.EventI;
import cep.app.ports.CEPBusManagementInboundPort;
import cep.app.ports.EventReceptionInboundPort;
import fr.sorbonne_u.components.AbstractComponent;
import fr.sorbonne_u.components.annotations.OfferedInterfaces;
import fr.sorbonne_u.components.annotations.RequiredInterfaces;


@OfferedInterfaces(offered = {CEPBusManagementCI.class, EventReceptionCI.class})
@RequiredInterfaces(required = {CEPBusManagementCI.class, EventEmissionCI.class})
public class OldCEPBus extends AbstractComponent {

    public static final String INBOUND_PORT_URI = "busiURI";
    protected CEPBusManagementInboundPort busi;
    protected EventReceptionInboundPort erbp;

    protected OldCEPBus() throws Exception {
        super(1, 0);
        this.initialise();
    }

    protected OldCEPBus(String reflectionInboundPortURI) throws Exception {
        super(reflectionInboundPortURI, 1, 0);
        this.initialise();
    }

    protected void initialise() throws Exception {
        this.busi = this.createPort();
        //this.busi.publishPort();
        this.erbp = new EventReceptionInboundPort(this);
        //this.erbp.publishPort();
    }

    @Override
    public void execute() throws Exception {
        System.out.println("gggggg");
        System.out.println("eeeeeeee " + erbp.getPortURI());
    }

    protected CEPBusManagementInboundPort createPort() throws Exception {
        return new CEPBusManagementInboundPort(INBOUND_PORT_URI, this);
    }

    public void sendEvent(String emitterURI, String destinationURI, EventI e) {
        System.out.println("Event recu !");
    }


    public Object registerEventReceptor(String uri, String inboundPortURI) {
        return null;
    }

    public Object registerCommandExecutor(String uri, String inboundPortURI) {
        return null;
    }

    public void receiveEvent(String uri, EventI e) {

    }
}
