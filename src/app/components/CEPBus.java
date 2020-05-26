package app.components;

import fr.sorbonne_u.components.AbstractComponent;
import fr.sorbonne_u.components.annotations.OfferedInterfaces;
import fr.sorbonne_u.components.annotations.RequiredInterfaces;
import fr.sorbonne_u.components.exceptions.ComponentShutdownException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import app.interfaces.bus.CEPBusManagementCI;
import app.interfaces.bus.EventEmissionCI;
import app.interfaces.bus.EventReceptionCI;
import app.interfaces.components.EventReceptionI;
import app.interfaces.events.EventI;
import app.ports.CEPBusManagementInboundPort;
import app.ports.EventReceptionInboundPort;
import app.ports.PresenceDetectorInboundPort;
import app.ports.PresenceDetectorOutboundPort;

@OfferedInterfaces(offered = {CEPBusManagementCI.class, EventReceptionCI.class})
@RequiredInterfaces(required = {EventEmissionCI.class})
public class CEPBus extends AbstractComponent implements EventEmissionCI {

	public static final String INBOUND_PORT_URI = "busiURI";
	protected CEPBusInboundPort busi;
	protected EventReceptionInboundPort erip;
	protected Map<String, ArrayList<String>> emmeteurCorrelateur; // TODO rename

	protected CEPBus() throws Exception {
		super(1, 0);
		this.initialise();
	}

	protected CEPBus(String reflectionInboundPortURI) throws Exception {
		super(reflectionInboundPortURI, 1, 0);
		this.initialise();
	}

	protected void initialise() throws Exception {
		emmeteurCorrelateur = new HashMap<String,ArrayList<String>>();

		this.busi = this.createPort();
		this.busi.publishPort();
		this.erip = new EventReceptionInboundPort(this);
		this.erip.publishPort();
	}

	@Override
	public void execute() throws Exception {
		System.out.println("gggggg");
		System.out.println("eeeeeeee "+erip.getPortURI());
	}

	protected CEPBusManagementInboundPort createPort() throws Exception {
		return new CEPBusManagementInboundPort(INBOUND_PORT_URI, this);
	}

	@Override
	public void sendEvent(String emitterURI, String destinationURI, EventI e) {
		System.out.println("Event recu ! la room = "+ e.getProperty("room"));
	}

	public void receiveEvent(String emitteurURI, EventI e) throws Exception {
		System.out.println("receive event " + e.getProperty("room"));
	}

	/**
	 * @see fr.sorbonne_u.components.AbstractComponent#shutdown()
	 */
	@Override
	public void shutdown() throws ComponentShutdownException {
		try {
			this.busi.unpublishPort();
			this.erbp.unpublishPort();
		} catch (Exception e) {
			throw new ComponentShutdownException(e);
		}
		super.shutdown();
	}

	@Override
	public void multiSendEvent(String emitterURI, String[] destinationURIs, EventI e) throws Exception {
		// TODO Auto-generated method stub
	}
}
