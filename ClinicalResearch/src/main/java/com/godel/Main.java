package com.godel;

import com.godel.dto.PatientDTO;
import com.godel.dto.StudyDTO;
import com.godel.doa.PatientDAO;
import com.godel.doa.StudyDAO;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setName("Praseed");
        patientDTO.setGender("Male");
        patientDTO.setAge(34);
       // patientDTO.setId(001);
        patientDTO.setConditionType("Diabetes");
        patientDTO.setRecuitmentDate(new Date());
        PatientDAO patientDao = new PatientDAO();
       // System.out.println(patientDao.create(patientDTO));
        patientDTO.setId(1);
        System.out.println(patientDTO.getId());
      //  patientDTO = patientDao.get(patientDTO.getId());
        System.out.println(patientDTO.getId());
        System.out.println(patientDTO.getName());
        System.out.println(patientDTO.getRecuitmentDate());

        StudyDTO studyDTO = new StudyDTO();
        studyDTO.setTitle("Effects of Sleep on Cognitive Performance");
        studyDTO.setDescription("Investigates how sleep duration impacts cognitive abilities.");
        studyDTO.setTherapeutics("Neuroscience");
        studyDTO.setStatus("Recruiting");
        StudyDAO studyDOA = new StudyDAO();
        studyDOA.create(studyDTO);
        studyDTO.setId(1);
        studyDTO = studyDOA.get(studyDTO.getId());
        System.out.println(studyDTO.getDescription());
    }
}