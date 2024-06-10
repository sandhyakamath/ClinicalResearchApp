package com.godel.service;

import com.godel.dto.PatientDTO;

import java.util.List;

public interface IPatientService {
     boolean save(PatientDTO patientDTO);
     PatientDTO get(int patientId);

     List<PatientDTO> getAll();
     boolean update(PatientDTO patientDTO);

     boolean delete(int patientId);
}
