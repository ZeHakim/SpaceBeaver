package app.components;

import app.ports.LightInboundPort;
import fr.sorbonne_u.components.AbstractComponent;
import fr.sorbonne_u.components.exceptions.ComponentShutdownException;
/**
 * Composant lampe qui peut donc s'�teindre ou s'allumer
 * @author Gabriel Bouchez
 */
public class LightComponent extends	AbstractComponent {
	
	private boolean activated;
	private LightInboundPort inBoundPort;

	public LightComponent(int nbThreads, int nbSchedulableThreads) throws Exception {
		super(1, 0);
		activated= false;
		initialise();
	}
	
	/**
	 * initialise le port entrant
	 * @throws Exception
	 */
	protected void	initialise() throws Exception{
		this.inBoundPort = new LightInboundPort(this) ;
		this.inBoundPort.publishPort() ;
	}
	
	/**
	 * allume la lumi�re si elle ne l'�tait pas d�ja
	 */
	public void switchOn() {
		//TODO cr�er une classe de messages?
		if (activated==false) {
			System.out.println("j'allume la lumiere ");
			activated=true;
		}
	}
	
	/**
	 * �teint la lumi�re si elle ne l'est pas d�ja
	 */
	public void switchOff() {
		//TODO cr�er une classe de messages commme dans l'exmple des regles?  
		if (activated) {
			System.out.println("j'�teins la lumiere ");
			activated=false;
		}
	}
	
	@Override
	public void	shutdown() throws ComponentShutdownException{
		try {
			this.inBoundPort.unpublishPort() ;
		} catch (Exception e) {
			throw new ComponentShutdownException(e) ;
		}
		super.shutdown();
	}
	
	
}
