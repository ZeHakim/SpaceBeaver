package app.interfaces.rules;


@FunctionalInterface
public interface EventMatcherI {
	public boolean match (EventI e);
}
