package app.components;

import app.ports.LightInboundPort;
import fr.sorbonne_u.components.AbstractComponent;
import fr.sorbonne_u.components.exceptions.ComponentShutdownException;
/**
 * Composant lampe qui peut donc s'éteindre ou s'allumer
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
	 * allume la lumière si elle ne l'était pas déja
	 */
	public void switchOn() {
		//TODO créer une classe de messages?
		if (activated==false) {
			System.out.println("j'allume la lumiere ");
			activated=true;
		}
	}
	
	/**
	 * éteint la lumière si elle ne l'est pas déja
	 */
	public void switchOff() {
		//TODO créer une classe de messages commme dans l'exmple des regles?  
		if (activated) {
			System.out.println("j'éteins la lumiere ");
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
