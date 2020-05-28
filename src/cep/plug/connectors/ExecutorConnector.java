package cep.plug.connectors;

import cep.domain.correlators.ExecutorCommandI;
import cep.interfaces.ExecutorCI;
import fr.sorbonne_u.components.connectors.AbstractConnector;

public class ExecutorConnector extends AbstractConnector implements ExecutorCI {

    @Override
    public void execute(ExecutorCommandI command) throws Exception {
        ((ExecutorCI) this.offering).execute(command);
    }
}
