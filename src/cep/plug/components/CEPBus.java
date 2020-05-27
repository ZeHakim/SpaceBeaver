package cep.plug.components;


import cep.CVM;
import cep.domain.events.EventBase;
import cep.interfaces.bus.CEPBusManagementCI;
import cep.interfaces.bus.EventEmissionCI;
import cep.interfaces.bus.EventReceptionCI;
import cep.domain.events.EventI;
import fr.sorbonne_u.components.AbstractComponent;
import fr.sorbonne_u.components.annotations.OfferedInterfaces;
import fr.sorbonne_u.components.annotations.RequiredInterfaces;
import fr.sorbonne_u.components.exceptions.ComponentShutdownException;
import cep.plug.ports.CEPBusManagementInboundPort;
import cep.plug.ports.EventEmissionOutboundPort;
import cep.plug.ports.EventReceptionInboundPort;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@RequiredInterfaces(required = {EventEmissionCI.class})
@OfferedInterfaces(offered = {CEPBusManagementCI.class, EventReceptionCI.class})
public class CEPBus extends AbstractComponent {

    protected CEPBusManagementInboundPort bmip;
    protected EventReceptionInboundPort brip;
    protected EventEmissionCI eeop;
    protected ConcurrentMap<String, EventBase> sendersEvents;
    protected ConcurrentMap<String, String> sendersCorrelators;
    protected ConcurrentMap<String, String> executors;

    protected CEPBus(String uri1, String uri2,String uri3) throws Exception {
        super(1, 0);
        this.sendersEvents = new ConcurrentHashMap<>();
        this.sendersCorrelators = new ConcurrentHashMap<>();
        this.executors = new ConcurrentHashMap<>();
        this.bmip = new CEPBusManagementInboundPort(uri1, this);
        this.brip = new EventReceptionInboundPort(uri2, this);
        this.eeop = new EventEmissionOutboundPort(uri3, this);
        this.bmip.publishPort();
        this.brip.publishPort();
    }

    public Object registerEventReceptor(String uri, String inboundPortURI) throws Exception {

        System.out.println("CEPBus register " + uri + " to transmitte on port=" + inboundPortURI);
        return sendersEvents.put(uri, new EventBase());
    }

    public Object registerCommandExecutor(String uri, String inboundPortURI) throws Exception {
        System.out.println("CEPBus register " + uri + " to execute command on port=" + inboundPortURI);
        return executors.put(uri, inboundPortURI);
    }


    public EventI receiveEvent(String emitterURI, EventI e) {
        EventBase eventBase;
        if (sendersEvents.containsKey(emitterURI) && (sendersEvents.get(emitterURI) != null)) {
            eventBase = sendersEvents.get(emitterURI);
        } else {
            eventBase = new EventBase();
        }
        eventBase.addEvent(e);
        assert eventBase.appearsIn(e);
        sendersEvents.put(emitterURI, eventBase);
        sendersCorrelators.put(emitterURI, "destinationURI");
        System.out.println("CEPBus receiveEvent from=" + emitterURI + " to=" + emitterURI + ", event=" + e.getURI());
        return e;
    }

    @Override
    public void execute() throws Exception {
        sendersEvents.keySet().forEach(emitterURI -> {
            if (sendersCorrelators.containsKey(emitterURI))
                sendersEvents.get(emitterURI).getEvents()
                        .forEach(eventI -> {
                            try {
                                this.eeop.sendEvent("CEP-BUS", CVM.THERMOSTAT_COMMAND_IN, eventI);
                                System.out.println("CEPBus sendEvent from=" + emitterURI + " to=" + emitterURI
                                        + ", event=" + eventI.getURI());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        });
        });
    }

    @Override
    public void finalise() throws Exception {
        super.finalise();
    }


    @Override
    public void shutdown() throws ComponentShutdownException {
        try {
            this.bmip.unpublishPort();
            this.brip.unpublishPort();
        } catch (Exception e) {
            throw new ComponentShutdownException(e);
        }
        super.shutdown();
    }
}
