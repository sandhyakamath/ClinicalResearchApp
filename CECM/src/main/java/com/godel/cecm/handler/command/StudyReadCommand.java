package com.godel.cecm.handler.command;

import com.godel.cecm.handler.ComputationContext;
import com.godel.service.IStudyService;
import org.springframework.beans.factory.annotation.Autowired;

public class StudyReadCommand extends BaseCommand {
    @Autowired
    IStudyService service;

    @Override
    public boolean execute(ComputationContext context) {
        int id = (Integer) context.get("cargo");
        context.put("cargo",service.get(id));
        return true;
    }
}
