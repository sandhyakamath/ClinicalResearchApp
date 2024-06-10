package com.godel.cecm.handler.command;

import com.godel.cecm.handler.ComputationContext;
import com.godel.dto.StudyDTO;
import com.godel.service.IStudyService;
import org.springframework.beans.factory.annotation.Autowired;

public class StudyUpdateCommand extends BaseCommand {
    @Autowired
    IStudyService service;

    @Override
    public boolean execute(ComputationContext context) {
        StudyDTO studyDTO = (StudyDTO) context.get("cargo");
        return service.update(studyDTO);
    }
}
