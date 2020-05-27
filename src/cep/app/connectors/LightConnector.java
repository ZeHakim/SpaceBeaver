package cep.app.connectors;

import cep.interfaces.components.LightServicesI;
import fr.sorbonne_u.components.connectors.AbstractConnector;

/**
 * The class <code>LightConnector</code> implements a connector between
 * the <code>corrélateurConsumerI</code> and the <code>LightServicesI</code> interfaces.
 *
 */
public class LightConnector extends AbstractConnector implements LightServicesI{

	/**
	 * implement the required interface by simply calling the inbound port with
	 * the corresponding offered method.
	 * 
	 */
	@Override
	public void switchOn() throws Exception {
		((LightServicesI)this.offering).switchOn() ;
		
	}

	/**
	 * implement the required interface by simply calling the inbound port with
	 * the corresponding offered method.
	 * 
	 */
	@Override
	public void switchOff() throws Exception {
		((LightServicesI)this.offering).switchOff() ;
		
	}

}
