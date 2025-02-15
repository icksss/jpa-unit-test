package jpastart.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class EMF {
    private static EntityManagerFactory emf;
    private static EntityManager em;
    

    public static void init() {
        emf = Persistence.createEntityManagerFactory("test");
    }
    
    public static EntityManager createEntityManager() {
        em = emf.createEntityManager();
        return em;
    }
    
    public static EntityTransaction getTransaction() {
        return em.getTransaction();
    }

    public static void close() {
        emf.close();
    }
} 