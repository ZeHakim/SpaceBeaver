package app.interfaces.bus;

import app.interfaces.commands.ExecutorCommandI;
import fr.sorbonne_u.components.interfaces.OfferedI;

public interface ExecutorCI extends OfferedI {

	public void execute(ExecutorCommandI command);
}
