package app.components;

import app.interfaces.bus.CEPBusManagementCI;
import app.interfaces.bus.EventEmissionCI;
import app.interfaces.bus.EventReceptionCI;
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
