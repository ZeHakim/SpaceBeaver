package cep.interfaces;

import cep.domain.events.EventI;
import fr.sorbonne_u.components.interfaces.OfferedI;

public interface EventReceptionCI extends OfferedI {

    void receiveEvent(String uri, EventI e) throws Exception;
}
