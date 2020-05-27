package cep.interfaces.bus;

import cep.interfaces.commands.ExecutorCommandI;
import fr.sorbonne_u.components.interfaces.OfferedI;
import fr.sorbonne_u.components.interfaces.RequiredI;

public interface ExecutorCI extends OfferedI, RequiredI {
	
	public void executeCommand(ExecutorCommandI command) throws Exception ;

}
