package app.ports;

import app.components.LightComponent;
import app.interfaces.components.LightServicesI;
import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractInboundPort;


/**
 * The class <code>LightInboundPort</code> implements
 * an inbound port offering the <code>LightServicesI</code>
 * component interface.
 *
 */
public class LightInboundPort extends AbstractInboundPort implements LightServicesI {
	//TODO , ExecutorCI doit il être implenté comme a la page 10?

	private static final long serialVersionUID = 1L;

	public LightInboundPort(ComponentI owner) throws Exception {
		super(LightServicesI.class, owner) ;
		assert owner instanceof LightComponent ;
	}

	@Override
	public void switchOn() throws Exception {
		((LightComponent) this.getOwner()).switchOn();
	}

	@Override
	public void switchOff() throws Exception {
		((LightComponent) this.getOwner()).switchOff();
	}
}
