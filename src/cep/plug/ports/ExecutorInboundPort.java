package cep.plug.ports;

import cep.domain.correlators.ExecutorCommandI;
import cep.interfaces.ExecutorCI;
import cep.plug.components.CommandExecutor;
import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractInboundPort;

public class ExecutorInboundPort<P extends CommandExecutor> extends AbstractInboundPort implements ExecutorCI {

    private static final long serialVersionUID = 1L;

    public ExecutorInboundPort(String uri, ComponentI owner) throws Exception {
        super(uri, ExecutorCI.class, owner);
    }

    @Override
    public void execute(ExecutorCommandI command) throws Exception {
        this.getOwner().handleRequestSync(
                o -> {
                    ((P) o).executeCommand(command);
                    return true;
                });
    }
}
