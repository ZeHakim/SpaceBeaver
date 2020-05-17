package app.interfaces.rules;

import app.interfaces.events.EventI;

@FunctionalInterface
public interface EventMatcherI {
	public boolean match (EventI e);
}
