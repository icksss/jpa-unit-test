package jpastart.services;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpastart.jpa.EMF;
import jpastart.reserve.model.User;

public class NewUserService {
    public void register(User user) {
        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx = EMF.getTransaction();
        try{
            tx.begin();
            em.persist(user);
            tx.commit();
        }catch(Exception e){
            tx.rollback();
            throw e;
        }finally{
            em.close();
        }
    }
}
