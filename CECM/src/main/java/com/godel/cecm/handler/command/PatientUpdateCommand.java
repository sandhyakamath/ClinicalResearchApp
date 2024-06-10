package com.godel.cecm.handler.command;

import com.godel.cecm.handler.ComputationContext;
import com.godel.dto.PatientDTO;
import com.godel.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;

public class PatientUpdateCommand extends BaseCommand{
    @Autowired
    IPatientService patientService;

    @Override
    public boolean execute(ComputationContext context) {
        PatientDTO patientDTO = (PatientDTO) context.get("cargo");
        return patientService.update(patientDTO);
    }
}
