package app.components;

import app.interfaces.CEPBusManagementCI;
import app.interfaces.EventEmissionCI;
import app.interfaces.EventReceptionCI;
import fr.sorbonne_u.components.AbstractComponent;
import fr.sorbonne_u.components.annotations.OfferedInterfaces;
import fr.sorbonne_u.components.annotations.RequiredInterfaces;

@OfferedInterfaces(offered = {CEPBusManagementCI.class, EventReceptionCI.class})
@RequiredInterfaces(required = {EventEmissionCI.class})
public class CEPBus extends AbstractComponent {

	protected CEPBus(int nbThreads, int nbSchedulableThreads) {
		super(1, 0);
	}

}
