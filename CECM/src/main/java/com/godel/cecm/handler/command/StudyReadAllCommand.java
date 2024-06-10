package com.godel.cecm.handler.command;

import com.godel.cecm.handler.ComputationContext;
import com.godel.service.IStudyService;
import org.springframework.beans.factory.annotation.Autowired;

public class StudyReadAllCommand extends BaseCommand {
    @Autowired
    IStudyService service;

    @Override
    public boolean execute(ComputationContext context) {
        context.put("cargo",service.getAll());
        return true;
    }
}
