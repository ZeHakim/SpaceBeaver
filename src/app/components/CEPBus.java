package app.components;

import app.interfaces.bus.CEPBusManagementCI;
import app.interfaces.bus.EventEmissionCI;
import app.interfaces.bus.EventReceptionCI;
import app.interfaces.events.EventI;
import app.ports.CEPBusInboundPort;
import app.ports.CEPBusOutboundPort;
import app.ports.EventReceptionInboundPort;
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
	protected EventReceptionInboundPort erbp;

	protected CEPBus() throws Exception {
		super(1, 0);
		this.initialise();
	}
	
	protected CEPBus(String reflectionInboundPortURI) throws Exception {
		super(reflectionInboundPortURI, 1, 0);
		this.initialise();
	}

	protected void initialise() throws Exception {
		this.busi = this.createPort();
		//this.busi.publishPort();
		this.erbp = new EventReceptionInboundPort(this);
		//this.erbp.publishPort();
	}
	
	@Override
	public void execute() throws Exception {
		System.out.println("gggggg");
		System.out.println("eeeeeeee "+erbp.getPortURI());
	}

	protected CEPBusInboundPort createPort() throws Exception {
		return new CEPBusInboundPort(INBOUND_PORT_URI, this);
	}

	public void sendEvent(String emitterURI, String destinationURI, EventI e) {
		System.out.println("Event recu !");
	}
	
	

}
