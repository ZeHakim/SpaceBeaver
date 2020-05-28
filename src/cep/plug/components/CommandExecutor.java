package cep.plug.components;

import cep.domain.correlators.ExecutorCommandI;

public interface CommandExecutor {

    void executeCommand(ExecutorCommandI command);
}
