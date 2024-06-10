package com.godel.mapper;

import com.godel.dto.PatientDTO;
import com.godel.dto.StudyDTO;
import com.godel.entity.Patient;
import com.godel.entity.Study;

public class Mapper {

    public static StudyDTO maptoStudyDTO(Study study) {
        StudyDTO studyDTO = new StudyDTO();
        studyDTO.setId(study.getId());
        studyDTO.setTitle(study.getTitle());
        studyDTO.setDescription(study.getDescription());
        studyDTO.setTherapeutics(study.getTherapeutics());
        studyDTO.setStatus(study.getStatus());
        return studyDTO;
    }
    public static Study maptoStudy(StudyDTO studyDTO) {
        Study study = new Study();
        study.setId(studyDTO.getId());
        study.setTitle(studyDTO.getTitle());
        study.setDescription(studyDTO.getDescription());
        study.setTherapeutics(studyDTO.getTherapeutics());
        study.setStatus(studyDTO.getStatus());
        return study;
    }

    public static Patient maptoPatient(PatientDTO patientDTO) {
        Patient patient = new Patient();
        patient.setId(patientDTO.getId());
        patient.setName(patientDTO.getName());
        patient.setGender(patientDTO.getGender());
        patient.setAge(patientDTO.getAge());
        patient.setConditionType(patientDTO.getConditionType());
        patient.setRecuitmentDate(patientDTO.getRecuitmentDate());
        return patient;
    }

    public static PatientDTO maptoPatientDTO(Patient patient) {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setId(patient.getId());
        patientDTO.setName(patient.getName());
        patientDTO.setGender(patient.getGender());
        patientDTO.setAge(patient.getAge());
        patientDTO.setConditionType(patient.getConditionType());
        patientDTO.setRecuitmentDate(patient.getRecuitmentDate());
        return patientDTO;
    }
}
