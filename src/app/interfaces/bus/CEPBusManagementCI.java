package app.interfaces.bus;

import fr.sorbonne_u.components.interfaces.OfferedI;
import fr.sorbonne_u.components.interfaces.RequiredI;

public interface CEPBusManagementCI extends OfferedI, RequiredI {
	
	/**
	 * ToDo
	 * @param uri
	 * @return res
	 * @throws Exception	<i>to do</i>.
	 * @author hakim
	 */
	public String getEventReceptionInboundPortURI(String uri) throws Exception ;
	
	/**
	 * Methode qui permet de s'abonner à un composant de type émetteur 
	 * @param uri
	 * @param inboundPortURI
	 * @throws Exception	<i>to do</i>.
	 * @author hakim
	 */
	public void registerEventReceptor(String uri, String inboundPortURI) throws Exception ;
	
	/**
	 * Methode qui permet de se désabonner à un composant de type émetteur  
	 * @param uri
	 * @throws Exception	<i>to do</i>.
	 * @author hakim
	 */
	public void unregisterEventReceptor(String uri) throws Exception ;
	
	/**
	 * Methode qui permet de ........... 
	 * @param uri
	 * @param inboundPortURI
	 * @throws Exception	<i>to do</i>.
	 * @author hakim
	 */
	public void registerCommandExecutor(String uri, String inboundPortURI) throws Exception ;
	
	/**
	 * Methode qui permet de ........... 
	 * @param excutorURI
	 * @throws Exception	<i>to do</i>.
	 * @author hakim
	 */
	public String getExecutorInboundPortURI(String excutorURI) throws Exception ;
	
	/**
	 * Methode qui permet de ........... 
	 * @param uri
	 * @throws Exception	<i>to do</i>.
	 * @author hakim
	 */
	public void unregisterCommandExecutor(String uri) throws Exception ;


}
