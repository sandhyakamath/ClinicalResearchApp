package com.godel.cecm.handler.command;

import com.godel.cecm.handler.ComputationContext;

public class BaseCommand implements IComputationCommand {
        @Override
        public boolean preExecute(ComputationContext context) {
            return true;
        }

        @Override
        public boolean execute(ComputationContext context) {
            return true;
        }

        @Override
        public boolean postExecute(ComputationContext context) {
            return true;
        }

}
