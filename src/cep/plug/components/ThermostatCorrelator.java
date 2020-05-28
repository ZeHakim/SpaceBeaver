package cep.plug.components;

import cep.CVM;
import cep.domain.correlators.TemperatureRegulationRule;
import cep.domain.events.EventBase;
import cep.domain.events.EventI;
import cep.interfaces.CEPBusManagementCI;
import cep.interfaces.EventReceptionCI;
import cep.interfaces.ExecutorCI;
import cep.plug.ports.EventReceptionInboundPort;
import cep.plug.ports.ExecutorOutboundPort;
import cep.plug.ports.RegistrationOutboundPort;
import fr.sorbonne_u.components.AbstractComponent;
import fr.sorbonne_u.components.annotations.OfferedInterfaces;
import fr.sorbonne_u.components.annotations.RequiredInterfaces;
import fr.sorbonne_u.components.exceptions.ComponentShutdownException;

import java.util.UUID;

@RequiredInterfaces(required = {ExecutorCI.class, CEPBusManagementCI.class})
@OfferedInterfaces(offered = {EventReceptionCI.class})
public class ThermostatCorrelator extends AbstractComponent implements EventReceptor {

    protected String URI;
    protected EventReceptionInboundPort<ThermostatCorrelator> erip;
    protected ExecutorOutboundPort exop;
    protected RegistrationOutboundPort reop;
    protected EventBase eventBase;

    protected ThermostatCorrelator(String uri1, String uri2, String uri3) throws Exception {
        super(1, 0);
        this.URI = "ThermostatCorrelator-" + UUID.randomUUID().toString();
        this.eventBase = new EventBase();
        this.erip = new EventReceptionInboundPort<ThermostatCorrelator>(uri1, this);
        this.exop = new ExecutorOutboundPort(uri2, this);
        this.reop = new RegistrationOutboundPort(uri3, this);
        this.erip.publishPort();
        this.exop.publishPort();
        this.reop.publishPort();
    }


    @Override
    public void saveEvent(String emitterURI, EventI e) throws Exception {
        eventBase.addEvent(e);
        assert eventBase.appearsIn(e);
        System.out.println("ThermostatCorrelator receiveEvent from=" + emitterURI + ", event=" + e.getURI());
        this.exop.execute(new TemperatureRegulationRule(eventBase));
    }

    @Override
    public void execute() throws Exception {
        this.reop.registerEventReceptor(this.URI, CVM.THERMOSTAT_CORRELATOR_EVENT_RECEPTION_IN);
    }

    @Override
    public void finalise() throws Exception {
        this.doPortDisconnection(this.reop.getPortURI());
        super.finalise();
    }


    @Override
    public void shutdown() throws ComponentShutdownException {
        try {
            this.erip.unpublishPort();
            this.exop.unpublishPort();
            this.reop.unpublishPort();
        } catch (Exception e) {
            throw new ComponentShutdownException(e);
        }
        super.shutdown();
    }
}
