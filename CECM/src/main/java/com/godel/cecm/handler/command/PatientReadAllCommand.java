package com.godel.cecm.handler.command;

import com.godel.cecm.handler.ComputationContext;
import com.godel.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;

public class PatientReadAllCommand extends BaseCommand{
    @Autowired
    IPatientService service;
   @Override
    public boolean execute(ComputationContext context) {
        context.put("cargo",service.getAll());
        return true;
    }
}
