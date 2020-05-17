package app.components;

import app.interfaces.bus.CEPBusManagementCI;
import app.interfaces.bus.EventEmissionCI;
import app.interfaces.bus.EventReceptionCI;
import app.interfaces.events.EventI;
import app.ports.CEPBusInboundPort;
import app.ports.CEPBusOutboundPort;
import app.ports.PresenceDetectorInboundPort;
import app.ports.PresenceDetectorOutboundPort;
import fr.sorbonne_u.components.AbstractComponent;
import fr.sorbonne_u.components.annotations.OfferedInterfaces;
import fr.sorbonne_u.components.annotations.RequiredInterfaces;


@OfferedInterfaces(offered = {CEPBusManagementCI.class, EventReceptionCI.class})
@RequiredInterfaces(required = {CEPBusManagementCI.class,EventEmissionCI.class})
public class CEPBus extends AbstractComponent {
	
	public static final String INBOUND_PORT_URI = "busiURI";
	protected CEPBusInboundPort busi;
	protected PresenceDetectorOutboundPort pdo;

	protected CEPBus() {
		super(1, 0);
	}
	
	protected CEPBus(String reflectionInboundPortURI) throws Exception {
		super(reflectionInboundPortURI, 1, 0);
		this.initialise();
	}

	protected void initialise() throws Exception {
		this.busi = this.createPort();
		this.busi.publishPort();
		this.pdo = new PresenceDetectorOutboundPort(this);
		this.pdo.publishPort();
	}

	protected CEPBusInboundPort createPort() throws Exception {
		return new CEPBusInboundPort(INBOUND_PORT_URI, this);
	}

	public void sendEvent(String emitterURI, String destinationURI, EventI e) {
		System.out.println("Event recu !");
	}

}
