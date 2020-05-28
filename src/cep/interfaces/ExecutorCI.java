package cep.interfaces;

import cep.domain.correlators.ExecutorCommandI;
import fr.sorbonne_u.components.interfaces.OfferedI;
import fr.sorbonne_u.components.interfaces.RequiredI;

public interface ExecutorCI extends OfferedI, RequiredI {

    void execute(ExecutorCommandI command) throws Exception;

}
