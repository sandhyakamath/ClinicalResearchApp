package com.godel.cecm.controller;

import com.godel.cecm.handler.CommandDispatcher;
import com.godel.cecm.handler.ComputationContext;
import com.godel.dto.PatientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    CommandDispatcher dispatcher;

    @GetMapping
    public PatientDTO get() {
        ComputationContext context = new ComputationContext();
        context.put("cargo", "cargo");
        dispatcher.dispatch(context, "PATIENT_GET_ALL");
        return (PatientDTO)context.get("cargo");
    }
    @GetMapping("/id")
    public List<PatientDTO> get(@PathVariable("id") int id) {
        ComputationContext context = new ComputationContext();
        context.put("cargo", id);
        dispatcher.dispatch(context,"PATIENT_GET");
        return (List)context.get("cargo");
    }

    @PostMapping
    public PatientDTO save(@RequestBody PatientDTO patientDTO) {
        ComputationContext context = new ComputationContext();
        context.put("cargo", patientDTO);
        dispatcher.dispatch(context,"PATIENT_ADD");
        return (PatientDTO)context.get("cargo");
    }
    @PutMapping
    public PatientDTO update(@RequestBody PatientDTO patientDTO) {
        ComputationContext context = new ComputationContext();
        context.put("cargo", patientDTO);
        dispatcher.dispatch(context,"PATIENT_UPDATE");
        return (PatientDTO)context.get("cargo");
    }

    @DeleteMapping("/id")
    public boolean delete(@PathVariable("id") int id) {
        ComputationContext context = new ComputationContext();
        context.put("cargo", id);
        return dispatcher.dispatch(context, "PATIENT_DELETE");
    }
}
