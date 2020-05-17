package app.interfaces.bus;

import fr.sorbonne_u.components.interfaces.OfferedI;

public interface CEPBusManagementCI extends OfferedI {

	public String getEventReceptionInboundPortURI(String uri);
	
	public void registerEventReceptor(String uri, String inboundPortURI);
	
	public void unregisterEventReceptor(String uri);
	
	public void registerCommandExecutor(String uri, String inboundPortURI);
	
	public String getExecutorInboundPortURI(String executorURI);
	
	public void unregisterCommandExecutor(String uri);
}
