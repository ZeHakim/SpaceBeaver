package cep.domain.events;
import java.io.Serializable;

public interface EventI extends Serializable {
	
	
	/**
	 * Methode qui renvoie l'uri
	 * @return URI
	 * @throws Exception	<i>to do</i>.
	 * @author Hakim
	 */
	public String getURI();
	
	/**
	 * Methode qui renvoie l'instance de TimeStamp
	 * @return result
	 * @throws Exception	<i>to do</i>.
	 * @author Hakim
	 */
	public TimeStamp getTimeStamp();
	
	/**
	 * Check si l'event posséde une property
	 * @return result
	 * @throws Exception	<i>to do</i>.
	 * @author Hakim
	 */
	public boolean hasProperty(String name);
	
	/**
	 * Methode qui renvoie la property
	 * @return result
	 * @throws Exception	<i>to do</i>.
	 * @author Hakim
	 */
	public Serializable getPropertyValue(String name);

}
