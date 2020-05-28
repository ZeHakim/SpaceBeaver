package cep.interfaces;

import cep.domain.events.EventI;
import fr.sorbonne_u.components.interfaces.RequiredI;

public interface EventEmissionCI extends RequiredI {

    void sendEvent(String emitterURI, String destinationPort, EventI e) throws Exception;


    void multiSendEvent(String emitterURI, String[] destinationURIs, EventI e) throws Exception;
}
