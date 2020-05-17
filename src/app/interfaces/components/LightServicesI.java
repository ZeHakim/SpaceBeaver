package app.interfaces.components;

import fr.sorbonne_u.components.interfaces.OfferedI;

/**
 * The component interface <code>LightServicesI</code>
 * defines the signatures of methods that light on or off the light.
 *
 */
public interface LightServicesI extends OfferedI {
	/**
	 * allume la lumière de la piece
	 * @throws Exception 
	 */
	public void switchOn() throws Exception;
	
	/**
	 * éteint la lumière de la pièce
	 * @throws Exception 
	 */
	public void switchOff() throws Exception;
}
