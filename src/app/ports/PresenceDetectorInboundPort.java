package app.ports;

import app.components.PresenceDetector;
import app.interfaces.components.PresenceDetectorCI;
import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractInboundPort;


public class PresenceDetectorInboundPort extends AbstractInboundPort implements PresenceDetectorCI {
	private static final long serialVersionUID = 1L;


	public PresenceDetectorInboundPort(ComponentI owner) throws Exception {
		super(PresenceDetectorCI.class, owner);
		assert owner instanceof PresenceDetector;
	}

	public PresenceDetectorInboundPort(String uri, ComponentI owner) throws Exception {
		super(uri, PresenceDetectorCI.class, owner);
		assert owner instanceof PresenceDetector;
	}

	protected PresenceDetectorInboundPort(Class<?> implementedInterface, ComponentI owner)
			throws Exception {
		super(implementedInterface, owner);
		assert owner instanceof PresenceDetector;
	}

	protected PresenceDetectorInboundPort(String uri, Class<?> implementedInterface, ComponentI owner)
			throws Exception {
		super(uri, implementedInterface, owner);
		assert owner instanceof PresenceDetector;
	}
	

	@Override
	public void emitDetectionEvent() throws Exception {
		this.getOwner().runTask(o -> {
			try {
				((PresenceDetector) o).emitEventDetector();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	@Override
	public void registration() throws Exception {
		this.getOwner().runTask(o -> {
			try {
				((PresenceDetector) o).registration();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
	}

}
