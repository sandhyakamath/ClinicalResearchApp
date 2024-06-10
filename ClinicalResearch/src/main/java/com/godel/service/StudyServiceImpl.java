package com.godel.service;

import com.godel.doa.StudyDAO;
import com.godel.dto.StudyDTO;

import java.util.List;

public class StudyServiceImpl implements IStudyService {
    StudyDAO studyDAO =  new StudyDAO();
    @Override
    public boolean save(StudyDTO studyDTO) {
        return studyDAO.create(studyDTO);
    }
    @Override
    public StudyDTO get(int patientId) {
       return studyDAO.get(patientId);
    }
    @Override
    public List<StudyDTO> getAll() {
        return studyDAO.getAll();
    }
    @Override
    public boolean update(StudyDTO studyDTO) {
       return studyDAO.update(studyDTO);
    }
    @Override
    public boolean delete(int  studyId) {
       return studyDAO.delete(studyId);
    }

}
