package com.godel.cecm.handler.command;

import com.godel.cecm.handler.ComputationContext;
import org.springframework.stereotype.Service;

@Service
public interface IComputationCommand {
        public boolean preExecute(ComputationContext context);

        public boolean execute(ComputationContext context);

        public boolean postExecute(ComputationContext context);
}
