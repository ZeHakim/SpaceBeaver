package app.components;

import app.components.events.AtomicEvent;
import app.connectors.CEPBusConnector;
import app.connectors.EventEmissionConnector;
import app.interfaces.bus.EventEmissionCI;
import app.interfaces.components.PresenceDetectorCI;
import app.interfaces.events.AtomicEventI;
import app.interfaces.events.EventI;
import app.ports.CEPBusManagmentInboundPort;
import app.ports.CEPBusManagmentOutboundPort;
import app.ports.EventEmissionOutboundPort;
import app.ports.PresenceDetectorInboundPort;
import app.ports.PresenceDetectorOutboundPort;
import fr.sorbonne_u.components.AbstractComponent;
import fr.sorbonne_u.components.annotations.OfferedInterfaces;
import fr.sorbonne_u.components.annotations.RequiredInterfaces;
import fr.sorbonne_u.components.exceptions.ComponentShutdownException;


//-----------------------------------------------------------------------------
/**
* The class <code>PresenceDetection</code> implements a calculator
* component which rather than being called synchronously and returning a result
* as usual, services are called asynchronously and send their result through a
* specific reception interface using a port URI passed as parameters.
*
* <p>
* <strong>Description</strong>
* </p>
* 
* <p>
* For those who have been exposed to this kind of things, the use of a method
* call at the end of the service to send back the result is comparable to a
* form of continuation-passing style.
* </p>
* 
* <p>
* <strong>Invariant</strong>
* </p>
* 
* <pre>
* invariant		true
* </pre>
* 
* <p>
* Created on : 2020-05-05
* </p>
* 
* @author 
*/
@RequiredInterfaces(required = {  EventEmissionCI.class })
public class PresenceDetector extends AbstractComponent  {
	
	public static final String INBOUND_PORT_URI = "pdURI";
	
	public static final String CORR_URI = "pdURI";
	
	protected EventEmissionOutboundPort eeobp;
//	protected PresenceDetectorInboundPort pdi;
	
	private static int count = 0;
	private static final String room = "15";
	
	protected PresenceDetector() throws Exception{
		super(1, 0);
		this.initialise();
	}

	protected PresenceDetector(String reflectionInboundPortURI) {
		super(reflectionInboundPortURI, 1, 0);
	}
	
	protected void initialise() throws Exception {
//		this.pdi = this.createPort();
//		this.pdi.publishPort();
		this.eeobp = new EventEmissionOutboundPort(this);
		this.eeobp.publishPort();
	}
	
//	protected PresenceDetectorInboundPort createPort() throws Exception {
//		return new PresenceDetectorInboundPort(INBOUND_PORT_URI, this);
//	}
	
	public void emitEventDetector() throws Exception { 
		count++;
		AtomicEventI event = new AtomicEvent("Detection presence "+count);
		event.putProperty("room", room);
		// todo call offredI of bus
		this.doPortConnection(this.eeobp.getPortURI(),CEPBus.INBOUND_PORT_URI, EventEmissionConnector.class.getCanonicalName());
		System.out.println("juste aprés doPortConnection");
		System.out.println("juste avant le sendEvent");
		eeobp.sendEvent(INBOUND_PORT_URI, CORR_URI, event);
		System.out.println("juste après le sendEvent");
		this.doPortDisconnection(this.eeobp.getClientPortURI());
	}
	
	@Override
	public void execute() throws Exception {
		emitEventDetector();
	}

	public void registration() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * @see fr.sorbonne_u.components.AbstractComponent#shutdown()
	 */
	@Override
	public void shutdown() throws ComponentShutdownException {
		try {
//			this.pdi.unpublishPort();
			this.eeobp.unpublishPort();
		} catch (Exception e) {
			throw new ComponentShutdownException(e);
		}
		super.shutdown();
	}

}
