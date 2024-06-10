package com.godel.cecm.handler.command;

import com.godel.cecm.handler.ComputationContext;

import com.godel.dto.PatientDTO;
import com.godel.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;

public class PatientCreateCommand extends BaseCommand {
    @Autowired
    IPatientService service;

    @Override
    public boolean execute(ComputationContext context) {
        PatientDTO patientDTO = (PatientDTO) context.get("cargo");
        return service.save(patientDTO);
    }
}
