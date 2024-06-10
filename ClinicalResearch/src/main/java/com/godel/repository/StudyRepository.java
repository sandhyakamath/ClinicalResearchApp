package com.godel.repository;

import com.godel.dto.StudyDTO;
import com.godel.entity.Patient;
import com.godel.entity.Study;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class StudyRepository {
    private EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.godel.clinicalResearchData");
        return emf.createEntityManager();
    }

    public void create(Study study) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(study);
        entityManager.getTransaction().commit();
    }
    public Study get(int studyId) {
        EntityManager entityManager = getEntityManager();
        Study study = entityManager.find(Study.class, studyId);
        entityManager.detach(study);
        return study;
    }

    public List<Study> getAll() {
        EntityManager entityManager = getEntityManager();
        TypedQuery<Study> query = entityManager.createQuery("SELECT s FROM Study s", Study.class);
        return query.getResultList();
    }

    public void update(Study study) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(study);
        entityManager.getTransaction().commit();
    }
    public void delete(int studyId) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        Study study = entityManager.find(Study.class, studyId);
        entityManager.remove(study);
        entityManager.getTransaction().commit();
    }
}
