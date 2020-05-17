package app.interfaces.bus;

import app.interfaces.commands.ExecutorCommandI;
import fr.sorbonne_u.components.interfaces.OfferedI;
import fr.sorbonne_u.components.interfaces.RequiredI;

public interface ExecutorCI extends OfferedI, RequiredI {
	
	public void execute(ExecutorCommandI command) throws Exception ;

	public void execute(ExecutorCommandI command);
}
