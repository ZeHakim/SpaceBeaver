package cep.plug.components;


import cep.CVM;
import cep.interfaces.bus.CEPBusManagementCI;
import cep.interfaces.bus.ExecutorCI;
import cep.interfaces.commands.ExecutorCommandI;
import fr.sorbonne_u.components.AbstractComponent;
import fr.sorbonne_u.components.annotations.OfferedInterfaces;
import fr.sorbonne_u.components.annotations.RequiredInterfaces;
import fr.sorbonne_u.components.exceptions.ComponentShutdownException;
import cep.plug.ports.ExecutorInboundPort;
import cep.plug.ports.RegistrationOutboundPort;

import java.util.UUID;

@RequiredInterfaces(required = {CEPBusManagementCI.class})
@OfferedInterfaces(offered = {ExecutorCI.class})
public class ThermostatCommand extends AbstractComponent {

    protected RegistrationOutboundPort reop;
    protected ExecutorInboundPort exip;
    protected String URI;

    protected ThermostatCommand(String uri1, String uri2) throws Exception {
        super(1, 0);
        this.URI = "ThermostatCommand-" + UUID.randomUUID().toString();
        this.exip = new ExecutorInboundPort(uri1, this);
        this.reop = new RegistrationOutboundPort(uri2, this);
        this.exip.publishPort();
        this.reop.publishPort();
    }

    @Override
    public void execute() throws Exception {
        this.reop.registerCommandExecutor(this.URI, CVM.THERMOSTAT_COMMAND_IN);
    }

    @Override
    public void finalise() throws Exception {
        this.doPortDisconnection(this.reop.getPortURI());
        super.finalise();
    }

    @Override
    public void shutdown() throws ComponentShutdownException {
        try {
            this.exip.unpublishPort();
            this.reop.unpublishPort();
        } catch (Exception e) {
            throw new ComponentShutdownException(e);
        }
        super.shutdown();
    }

    public boolean executeCommand(ExecutorCommandI command) {
        command.execute();
        return true;
    }
}
