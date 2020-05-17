package app.interfaces.rules;

import app.interfaces.events.EventI;

/**
 * Permet de tester les events avec des  règles sous forme de lambda-expression
 * @author Gabriel Bouchez
 *
 */
@FunctionalInterface
public interface EventMatcherI {
	public boolean match (EventI e);
}
