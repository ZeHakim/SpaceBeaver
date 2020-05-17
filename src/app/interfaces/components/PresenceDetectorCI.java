package app.interfaces.components;

import app.interfaces.events.EventI;
import fr.sorbonne_u.components.interfaces.OfferedI;
import fr.sorbonne_u.components.interfaces.RequiredI;


//-----------------------------------------------------------------------------
/**
* The component interface <code>PresenceDetectorCI</code>
* defines the signatures of methods that imet eventDetection and registration
*
* <p><strong>Description</strong></p>
* 
* <p><strong>Invariant</strong></p>
* 
* <pre>
* invariant		true
* </pre>
* 
* <p>Created on : 2020-05-16</p>
* 
* @author hakim cherbal
*/
public interface PresenceDetectorCI extends OfferedI,RequiredI{
	
	/**
	 * add the two first parameter and return the result by calling a port
	 * offering the interface <code>ResultReceptionCI</code> which URI
	 * is given as the last parameter; the serial number allows the caller
	 * to identify its call when receiving the result.
	 * 
	 * <p><strong>Contract</strong></p>
	 * 
	 * <pre>
	 * pre	resultReceptionInboundPortURI != null
	 * post	true			// no postcondition.
	 * </pre>
	 *
	 * @throws Exception	<i>to do</i>.
	 */
	public void emitDetectionEvent() throws Exception ;
	
	
	/**
	 * add the two first parameter and return the result by calling a port
	 * offering the interface <code>ResultReceptionCI</code> which URI
	 * is given as the last parameter; the serial number allows the caller
	 * to identify its call when receiving the result.
	 * 
	 * <p><strong>Contract</strong></p>
	 * 
	 * <pre>
	 * pre	resultReceptionInboundPortURI != null
	 * post	true			// no postcondition.
	 * </pre>
	 *
	 * @throws Exception	<i>to do</i>.
	 */
	public void registration() throws Exception ;
}
