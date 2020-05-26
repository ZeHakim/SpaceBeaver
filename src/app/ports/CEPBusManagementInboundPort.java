package app.ports;

import fr.sorbonne_u.components.ComponentI;
import fr.sorbonne_u.components.ports.AbstractInboundPort;

import app.components.CEPBus;
import app.interfaces.bus.CEPBusManagementCI;
import app.interfaces.bus.EventEmissionCI;
import app.interfaces.events.EventI;

public class CEPBusManagementInboundPort extends AbstractInboundPort implements CEPBusManagementCI {
	private static final long serialVersionUID = 1L;

	public CEPBusManagementInboundPort(ComponentI owner) throws Exception {
		super(CEPBusManagementCI.class, owner);
		assert owner instanceof CEPBus; // TODO ne faudrait-il pas faire le assert avant le super ?
	}

	public CEPBusManagementInboundPort(String uri, ComponentI owner) throws Exception {
		super(uri, CEPBusManagementCI.class, owner);
		assert owner instanceof CEPBus;
	}

	protected CEPBusManagementInboundPort(Class<?> implementedInterface, ComponentI owner) throws Exception {
		super(implementedInterface, owner);
		assert owner instanceof CEPBus;
	}

	protected CEPBusManagementInboundPort(String uri, Class<?> implementedInterface, ComponentI owner) throws Exception {
		super(uri, implementedInterface, owner);
		assert owner instanceof CEPBus;
	}

	@Override
	public String getEventReceptionInboundPortURI(String uri) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getExecutorInboundPortURI(String executorURI) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerEventReceptor(String uri, String inboundPortURI) throws Exception {
        // TODO a vérifier pour voir si on peut simplifier le cast
        this.getOwner().handleRequestSync(
            o -> (
                (CEPBus) o
            ).registerEventReceptor(uri, inboundPortURI)
        );
    }

	@Override
	public void unregisterEventReceptor(String uri) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void registerCommandExecutor(String uri, String inboundPortURI) throws Exception {
        this.getOwner().handleRequestSync(
            o -> (
                (CEPBus) o
            ).registerCommandExecutor(uri, inboundPortURI)
        );
	}

	@Override
	public void unregisterCommandExecutor(String uri) throws Exception {
		// TODO Auto-generated method stub
	}
}
