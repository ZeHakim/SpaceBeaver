package app.ports;

import java.util.concurrent.RejectedExecutionException;

import app.components.CEPBus;
import app.interfaces.bus.EventEmissionCI;
import app.interfaces.bus.EventReceptionCI;
import app.interfaces.events.EventI;
import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractInboundPort;

public class EventReceptionInboundPort extends AbstractInboundPort implements EventReceptionCI{
	
	private static final long serialVersionUID = 1L;

	public EventReceptionInboundPort(ComponentI owner) throws Exception {
		super(EventReceptionCI.class, owner);
	}

	public EventReceptionInboundPort(String uri, ComponentI owner) throws Exception {
		super(uri, EventReceptionCI.class, owner);
	}

	protected EventReceptionInboundPort(Class<?> implementedInterface, ComponentI owner)
			throws Exception {
		super(implementedInterface, owner);
	}

	protected EventReceptionInboundPort(String uri, Class<?> implementedInterface, ComponentI owner)
			throws Exception {
		super(uri, implementedInterface, owner);
	}

	
	/**
	 * Methode qui permet la reception d'vent 
	 * @param uri
	 * @param e
	 * @throws Exception	<i>to do</i>.
	 * @author hakim
	 * @throws AssertionError 
	 * @throws RejectedExecutionException 
	 */


	@Override
	public void receiveEvent(String uri, EventI e) throws Exception {
		this.getOwner().runTask(o -> {
			try {
				((CEPBus) o).receiveEvent(uri, e);
			} catch (Exception error) {
				error.printStackTrace();
			}
		});
		
	}

}

    @Override
    public void receiveEvent(String emitterURI, String destinationURI, EventI e) throws Exception {
                o -> ((CEPBus) o).receiveEvent(emitterURI, destinationURI, e));
        this.getOwner().handleRequestSync(
    }
}