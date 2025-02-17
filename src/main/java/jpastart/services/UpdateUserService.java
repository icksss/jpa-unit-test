package jpastart.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpastart.jpa.EMF;
import jpastart.reserve.model.User;

public class UpdateUserService {
    public void update(User user) {
        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx = EMF.getTransaction();
        try{
            tx.begin();
            // em.merge(user);
            User findUser = em.find(User.class, user.getEmail());
            findUser.changeName(user.getName());
            tx.commit();
        }catch(Exception e){
            tx.rollback();
            throw e;
        }finally{
            em.close();
        }
    }
}
