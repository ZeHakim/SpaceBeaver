package app.interfaces.bus;

import fr.sorbonne_u.components.interfaces.OfferedI;
import fr.sorbonne_u.components.interfaces.RequiredI;

import app.interfaces.commands.ExecutorCommandI;

public interface ExecutorCI extends OfferedI, RequiredI {

    public void execute(ExecutorCommandI command) throws Exception;
}
