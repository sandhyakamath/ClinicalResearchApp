package com.godel.doa;

import com.godel.dto.PatientDTO;
import com.godel.entity.Patient;
import com.godel.mapper.Mapper;
import com.godel.repository.PatientRepository;

import java.util.ArrayList;
import java.util.List;

public class PatientDAO {
    PatientRepository patientRepository = new PatientRepository();
    public boolean create(PatientDTO patientDTO) {
        Patient patient = Mapper.maptoPatient(patientDTO);
        patientRepository.create(patient);
        return true;
    }

    public PatientDTO get(int patientId) {
        return Mapper.maptoPatientDTO(patientRepository.get(patientId));
    }
    public List<PatientDTO> getAll() {
        List<PatientDTO> patientDTOList = new ArrayList<>();
        List<Patient> patientList = patientRepository.getAll();
        for ( Patient patient: patientList) {
            patientDTOList.add(Mapper.maptoPatientDTO(patient));
        }
        return patientDTOList;
    }
    public boolean update(PatientDTO patientDTO) {
         patientRepository.update(Mapper.maptoPatient(patientDTO));
         return true;
    }

    public boolean delete(int patientId) {
        patientRepository.delete(patientId);
        return true;
    }

}
