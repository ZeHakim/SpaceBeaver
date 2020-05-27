package cep.domain.correlators;

import cep.domain.events.EventI;

/**
 * Permet de tester les events avec des  r�gles sous forme de lambda-expression
 * @author Gabriel Bouchez
 *
 */
@FunctionalInterface
public interface EventMatcherI {
	public boolean match (EventI e);
}
