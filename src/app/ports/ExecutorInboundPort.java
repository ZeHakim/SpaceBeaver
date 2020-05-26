package org.diehl.ports;

import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractInboundPort;
import org.diehl.components.ExecutorCommandI;
import org.diehl.components.ThermostatCommand;
import org.diehl.interfaces.ExecutorCI;

public class ExecutorInboundPort extends AbstractInboundPort implements ExecutorCI {

    private static final long serialVersionUID = 1L;

    public ExecutorInboundPort(String uri, ComponentI owner) throws Exception {
        super(uri, ExecutorCI.class, owner);
    }

    @Override
    public void executeCommand(ExecutorCommandI command) throws Exception {
        this.getOwner().handleRequestSync(
                o -> ((ThermostatCommand) o).executeCommand(command));
    }
}
