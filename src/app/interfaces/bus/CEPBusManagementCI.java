package app.interfaces.bus;

import fr.sorbonne_u.components.interfaces.OfferedI;
import fr.sorbonne_u.components.interfaces.RequiredI;

public interface CEPBusManagementCI extends OfferedI, RequiredI {
	
	public String getEventReceptionInboundPortURI(String uri) throws Exception ;
	
	public void registerEventReceptor(String uri, String inboundPortURI) throws Exception ;
	
	public void unregisterEventReceptor(String uri) throws Exception ;
	
	public void registerCommandExecutor(String uri, String inboundPortURI) throws Exception ;
	
	public String getExecutorInboundPortURI(String excutorURI) throws Exception ;
	
	public void unregisterCommandExecutor(String uri) throws Exception ;


}
