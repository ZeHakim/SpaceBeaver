package cep.interfaces.components;

import fr.sorbonne_u.components.interfaces.OfferedI;

/**
 * The component interface <code>PresenceServicesI</code>
 * defines the signatures of methods that detect if there is some one or not in the room
 *
 */
public interface PresenceServicesI extends OfferedI{
	
	/**
	 * m�thode appel� � intervalle r�gulier pour qu'elle renvoit si oui ou non il y aun pr�sence dans la pi�ce
	 * @throws Exception 
	 */
	public void transmetDetection(boolean isSomeone) throws Exception;
	
}
