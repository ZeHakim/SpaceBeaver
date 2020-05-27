package cep.plug.components;


import cep.CVM;
import cep.domain.events.AtomicEvent;
import cep.interfaces.bus.CEPBusManagementCI;
import cep.interfaces.bus.EventEmissionCI;
import fr.sorbonne_u.components.AbstractComponent;
import fr.sorbonne_u.components.annotations.RequiredInterfaces;
import fr.sorbonne_u.components.exceptions.ComponentShutdownException;
import cep.plug.ports.EventEmissionOutboundPort;
import cep.plug.ports.RegistrationOutboundPort;

import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

@RequiredInterfaces(required = {EventEmissionCI.class, CEPBusManagementCI.class})
public class Thermostat extends AbstractComponent {

    protected EventEmissionOutboundPort eeop;
    protected RegistrationOutboundPort reop;
    protected String URI;

    protected Double ambientTemperature = 20.0;
    protected Random random;


    protected Thermostat(String uri1, String uri2) throws Exception {
        super(1, 0);
        this.URI = "Thermostat-" + UUID.randomUUID().toString();
        this.eeop = new EventEmissionOutboundPort(uri1, this);
        this.reop = new RegistrationOutboundPort(uri2, this);
        this.random = SecureRandom.getInstanceStrong();
        this.eeop.publishPort();
        this.reop.publishPort();
    }

    @Override
    public void execute() throws Exception {
        AtomicEvent temperatures = new AtomicEvent();
        temperatures.putProperty("ambient", ambientTemperature);
        Double targetTemperature = (random.nextDouble()) * 100.0;
        temperatures.putProperty("target", targetTemperature);
        this.reop.registerEventReceptor(this.URI, CVM.BUS_REGISTRATION_IN);
        this.eeop.sendEvent(this.URI, CVM.THERMOSTAT_COMMAND_IN, temperatures);
        System.out.println("Thermostat has emitted event Temperatures: (target=" + targetTemperature + "),(ambient=" +
                ambientTemperature + ")");
    }

    @Override
    public void finalise() throws Exception {
        this.doPortDisconnection(this.reop.getPortURI());
        super.finalise();
    }

    @Override
    public void shutdown() throws ComponentShutdownException {
        try {
            this.eeop.unpublishPort();
            this.reop.unpublishPort();
        } catch (Exception e) {
            throw new ComponentShutdownException(e);
        }
        super.shutdown();
    }
}
