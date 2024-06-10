package com.godel.doa;

import com.godel.dto.StudyDTO;
import com.godel.entity.Study;
import com.godel.mapper.Mapper;
import com.godel.repository.StudyRepository;

import java.util.ArrayList;
import java.util.List;

public class StudyDAO {
    StudyRepository studyRepository = new StudyRepository();
    public boolean create(StudyDTO studyDTO) {
        Study study = Mapper.maptoStudy(studyDTO);
        studyRepository.create(study);
        return true;
    }
    public StudyDTO get(int studyId) {
        return Mapper.maptoStudyDTO(studyRepository.get(studyId));
    }

    public List<StudyDTO> getAll() {
        List<StudyDTO> studyDTOList = new ArrayList<>();
        List<Study> studyList = studyRepository.getAll();
        for (Study study: studyList) {
            studyDTOList.add(Mapper.maptoStudyDTO(study));
        }
        return studyDTOList;
    }
    public boolean update(StudyDTO studyDTO) {
        Study study = Mapper.maptoStudy(studyDTO);
        studyRepository.update(study);
        return true;
    }

    public boolean delete(int studyId) {
        studyRepository.delete(studyId);
        return true;
    }


}
