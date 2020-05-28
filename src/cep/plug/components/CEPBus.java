package cep.plug.components;

import cep.CVM;
import cep.domain.events.EventI;
import cep.interfaces.CEPBusManagementCI;
import cep.interfaces.EventEmissionCI;
import cep.interfaces.EventReceptionCI;
import cep.plug.ports.CEPBusManagementInboundPort;
import cep.plug.ports.EventEmissionOutboundPort;
import cep.plug.ports.EventReceptionInboundPort;
import fr.sorbonne_u.components.AbstractComponent;
import fr.sorbonne_u.components.annotations.OfferedInterfaces;
import fr.sorbonne_u.components.annotations.RequiredInterfaces;
import fr.sorbonne_u.components.exceptions.ComponentShutdownException;

import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@RequiredInterfaces(required = {EventEmissionCI.class})
@OfferedInterfaces(offered = {CEPBusManagementCI.class, EventReceptionCI.class})
public class CEPBus extends AbstractComponent implements EventReceptor {

    protected CEPBusManagementInboundPort bmip;
    protected EventReceptionInboundPort<CEPBus> erip;
    protected EventEmissionOutboundPort eeop;
    protected ConcurrentMap<String, String> receiverPorts;
    protected Vector<String> senders;
    protected Vector<String> executors;
    protected String URI = "CEP-BUS";


    protected CEPBus(String uri1, String uri2, String uri3) throws Exception {
        super(1, 0);
        this.receiverPorts = new ConcurrentHashMap<>();
        this.senders = new Vector<>();
        this.executors = new Vector<>();
        this.bmip = new CEPBusManagementInboundPort(uri1, this);
        this.erip = new EventReceptionInboundPort<CEPBus>(uri2, this);
        this.eeop = new EventEmissionOutboundPort(uri3, this);
        this.bmip.publishPort();
        this.erip.publishPort();
    }

    public void registerEventReceptor(String uri, String inboundPortURI) {
        if (inboundPortURI == CVM.BUS_EVENT_RECEPTION_IN) {
            senders.add(uri);
            System.out.println("CEPBus register sender " + uri);
        } else {
            receiverPorts.put(uri, inboundPortURI);
            System.out.println("CEPBus register receiver " + uri + " to receive event on port=" + inboundPortURI);
        }
    }

    public void registerCommandExecutor(String uri, String inboundPortURI) {
        System.out.println("CEPBus register CommandExecutor " + uri + " to execute command on port=" + inboundPortURI);
        executors.add(uri);
    }

    @Override
    public void saveEvent(String emitterURI, EventI e) throws Exception {
        if (senders.contains(emitterURI)) {
            System.out.println("CEPBus receiveEvent from=" + emitterURI + ", event=" + e.getURI());
            this.eeop.sendEvent(this.URI, null, e);
            System.out.println("CEPBus has emitted event=" + e.getURI() + " from=" + emitterURI);
        }
    }

    @Override
    public void finalise() throws Exception {
        super.finalise();
    }


    @Override
    public void shutdown() throws ComponentShutdownException {
        try {
            this.bmip.unpublishPort();
            this.erip.unpublishPort();
        } catch (Exception e) {
            throw new ComponentShutdownException(e);
        }
        super.shutdown();
    }
}
