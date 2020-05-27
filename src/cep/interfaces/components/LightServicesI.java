package cep.interfaces.components;

import fr.sorbonne_u.components.interfaces.OfferedI;

/**
 * The component interface <code>LightServicesI</code>
 * defines the signatures of methods that light on or off the light.
 *
 */
public interface LightServicesI extends OfferedI {
	/**
	 * allume la lumi�re de la piece
	 * @throws Exception 
	 */
	public void switchOn() throws Exception;
	
	/**
	 * �teint la lumi�re de la pi�ce
	 * @throws Exception 
	 */
	public void switchOff() throws Exception;
}
