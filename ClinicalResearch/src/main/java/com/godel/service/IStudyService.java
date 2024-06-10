package com.godel.service;

import com.godel.dto.StudyDTO;

import java.util.List;

public interface IStudyService {
     boolean save(StudyDTO studyDTO);
     StudyDTO get(int patientId);

     List<StudyDTO> getAll();
     boolean update(StudyDTO studyDTO);

     boolean delete(int  studyId);
}
