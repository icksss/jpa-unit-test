package jpastart.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpastart.jpa.EMF;
import jpastart.reserve.model.User;

public class DeleteUserService {
    public void delete(User user) {
        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx = EMF.getTransaction();
        try{
            tx.begin();
            User findUser = em.find(User.class, user.getEmail());
            em.remove(findUser);
            tx.commit();
        }catch(Exception e){
            tx.rollback();
            System.out.println(e.getMessage() + "없는 사용자 삭제 요청");
            throw e;
        }finally{
            em.close();
        }
    }
}
