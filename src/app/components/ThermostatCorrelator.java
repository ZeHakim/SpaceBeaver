package app.components;

import fr.sorbonne_u.components.AbstractComponent;
import fr.sorbonne_u.components.annotations.OfferedInterfaces;
import fr.sorbonne_u.components.annotations.RequiredInterfaces;
import fr.sorbonne_u.components.exceptions.ComponentShutdownException;


import java.util.UUID;

import app.components.events.EventBase;
import app.interfaces.events.EventI;
import app.ports.CorrelatorReceptionInboundPort;
import app.ports.ExecutorOutboundPort;
import app.ports.RegistrationOutboundPort;

@RequiredInterfaces(required = {ExecutorCI.class, CEPBusManagementCI.class})
@OfferedInterfaces(offered = {EventReceptionCI.class})
public class ThermostatCorrelator extends AbstractComponent {

    protected String URI;
    protected CorrelatorReceptionInboundPort brip;
    protected ExecutorOutboundPort exop;
    protected RegistrationOutboundPort reop;
    protected EventBase eventBase;

    protected ThermostatCorrelator(String uri1, String uri2, String uri3) throws Exception {
        super(1, 0);
        this.URI = "ThermostatCorrelator-" + UUID.randomUUID().toString();
        this.eventBase = new EventBase();
        this.brip = new CorrelatorReceptionInboundPort(uri1, this);
        this.exop = new ExecutorOutboundPort(uri2, this);
        this.reop = new RegistrationOutboundPort(uri3, this);
        this.brip.publishPort();
        this.exop.publishPort();
        this.reop.publishPort();
    }

    public EventI receiveEvent(String emitterURI, String destinationURI, EventI e) {
        eventBase.addEvent(e);
        assert eventBase.appearsIn(e);
        System.out.println("ThermostatCorrelator receiveEvent from=" + emitterURI + " to=" + emitterURI + ", event=" + e.getURI());
        return e;
    }

    @Override
    public void execute() throws Exception {
        this.reop.registerEventReceptor(this.URI, CVM.BUS_REGISTRATION_IN);
        this.exop.executeCommand(new TemperatureRegulationRule(eventBase));
        eventBase.clear();
    }

    @Override
    public void finalise() throws Exception {
        this.doPortDisconnection(this.reop.getPortURI());
        super.finalise();
    }


    @Override
    public void shutdown() throws ComponentShutdownException {
        try {
            this.brip.unpublishPort();
            this.exop.unpublishPort();
            this.reop.unpublishPort();
        } catch (Exception e) {
            throw new ComponentShutdownException(e);
        }
        super.shutdown();
    }
}
