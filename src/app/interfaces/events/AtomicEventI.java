package app.components.interfaces;

import java.io.Serializable;

public interface AtomicEventI extends EventI{
	
	/**
	 * Methode pour set la property d'un event
	 * @return result
	 * @throws Exception	<i>to do</i>.
	 * @author Hakim
	 */
	public Serializable putProperty(String name, Serializable value);
	
	/**
	 * Methode pour supprimer la property d'un event
	 * @return result
	 * @throws Exception	<i>to do</i>.
	 * @author Hakim
	 */
	public Serializable removeProperty(String name);

}
