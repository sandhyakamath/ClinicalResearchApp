package com.godel.cecm.handler;

import com.godel.cecm.handler.command.IComputationCommand;
import org.springframework.beans.factory.annotation.Autowired;

public class CommandDispatcher {
    @Autowired
    ObjectFactory objectFactory;

    public boolean dispatch(ComputationContext context, String archetype) {
        IComputationCommand command = objectFactory.getInstance(archetype);
        return command.execute(context);
    }
}
