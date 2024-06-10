package com.godel.cecm.handler.command;

import com.godel.cecm.handler.ComputationContext;

import com.godel.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;

public class PatientReadCommand extends BaseCommand{
    @Autowired
    IPatientService service;
    @Override
    public boolean execute(ComputationContext context) {
        int patientId = (Integer) context.get("cargo");
        context.put("cargo",service.get(patientId));
        return true;
    }
}
