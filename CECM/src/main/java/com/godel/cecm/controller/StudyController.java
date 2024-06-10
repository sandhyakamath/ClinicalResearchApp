package com.godel.cecm.controller;

import com.godel.cecm.handler.CommandDispatcher;
import com.godel.cecm.handler.ComputationContext;

import com.godel.dto.StudyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/study")
public class StudyController {

    @Autowired
    CommandDispatcher dispatcher;

    @GetMapping
    public StudyDTO get() {
        ComputationContext context = new ComputationContext();
        context.put("cargo", "");
        dispatcher.dispatch(context, "STUDY_GET_ALL");
        return (StudyDTO)context.get("cargo");
    }
    @GetMapping("/id")
    public List<StudyDTO> get(@PathVariable("id") int id) {
        ComputationContext context = new ComputationContext();
        context.put("cargo", id);
        dispatcher.dispatch(context,"STUDY_GET");
        return (List)context.get("cargo");
    }

    @PostMapping
    public StudyDTO save(@RequestBody StudyDTO patientDTO) {
        ComputationContext context = new ComputationContext();
        context.put("cargo", patientDTO);
        dispatcher.dispatch(context,"STUDY_ADD");
        return (StudyDTO)context.get("cargo");
    }
    @PutMapping
    public StudyDTO update(@RequestBody StudyDTO patientDTO) {
        ComputationContext context = new ComputationContext();
        context.put("cargo", patientDTO);
        dispatcher.dispatch(context,"STUDY_UPDATE");
        return (StudyDTO)context.get("cargo");
    }

    @DeleteMapping("/id")
    public boolean delete(@PathVariable("id") int id) {
        ComputationContext context = new ComputationContext();
        context.put("cargo", id);
        return dispatcher.dispatch(context, "STUDY_DELETE");
    }

}
