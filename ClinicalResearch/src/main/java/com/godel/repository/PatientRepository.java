package com.godel.repository;

import com.godel.dto.PatientDTO;
import com.godel.entity.Patient;
import com.godel.utils.Helper;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class PatientRepository {

    private EntityManager getEntityManager() {
        return Helper.getEntityManager();
    }

    public void create(Patient patient) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(patient);
        entityManager.getTransaction().commit();
    }

    public List<Patient> getAll() {
        EntityManager entityManager = getEntityManager();
        TypedQuery<Patient> query = entityManager.createQuery("SELECT s FROM Patient s", Patient.class);
        return query.getResultList();
    }
    public Patient get(int patientId) {
        EntityManager entityManager = getEntityManager();
        Patient patient = entityManager.find(Patient.class, patientId);
        entityManager.detach(patient);
        return patient;
    }

    public void update(Patient patient) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(patient);
        entityManager.getTransaction().commit();
    }
    public void delete(int patientId) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        Patient patient = entityManager.find(Patient.class, patientId);
        entityManager.remove(patient);
        entityManager.getTransaction().commit();
    }
}
