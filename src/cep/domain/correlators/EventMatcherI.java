package cep.domain.correlators;

import cep.domain.events.EventI;

@FunctionalInterface
public interface EventMatcherI {
    boolean match(EventI e);
}
