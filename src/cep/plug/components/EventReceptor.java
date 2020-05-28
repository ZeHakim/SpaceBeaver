package cep.plug.components;

import cep.domain.events.EventI;

public interface EventReceptor {

    void saveEvent(String emitterURI, EventI e) throws Exception;
}
