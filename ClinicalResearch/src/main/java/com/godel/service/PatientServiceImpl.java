package com.godel.service;

import com.godel.doa.PatientDAO;
import com.godel.dto.PatientDTO;

import java.util.List;

public class PatientServiceImpl implements IPatientService{
    PatientDAO patientDAO =  new PatientDAO();
    @Override
    public boolean save(PatientDTO patientDTO) {
        return patientDAO.create(patientDTO);
    }
    @Override
    public PatientDTO get(int patientId) {
        return patientDAO.get(patientId);
    }
    @Override
    public List<PatientDTO> getAll() {
        return patientDAO.getAll();
    }
    @Override
    public boolean update(PatientDTO patientDTO) {
        return patientDAO.update(patientDTO);
    }

    @Override
    public boolean delete(int patientId) {
        return patientDAO.delete(patientId);
    }
}
