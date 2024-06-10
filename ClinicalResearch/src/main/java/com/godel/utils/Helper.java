package com.godel.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Helper {
    public static EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.godel.clinicalResearchData");
        return emf.createEntityManager();
    }
}
