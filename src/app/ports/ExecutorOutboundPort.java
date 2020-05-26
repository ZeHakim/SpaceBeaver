package app.ports;

import app.interfaces.bus.ExecutorCI;
import app.interfaces.commands.ExecutorCommandI;
import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractOutboundPort;

public class ExecutorOutboundPort extends AbstractOutboundPort implements ExecutorCI {

    private static final long serialVersionUID = 1L;


    public ExecutorOutboundPort(String uri, ComponentI owner) throws Exception {
        super(uri, ExecutorCI.class, owner);
    }


//    @Override
//    public void executeCommand(ExecutorCommandI command) throws Exception {
//        ((ExecutorCI) this.connector).executeCommand(command);
//    }


	@Override
	public void execute(ExecutorCommandI command) throws Exception {
		((ExecutorCI) this.connector).execute(command);
		
	}
}
