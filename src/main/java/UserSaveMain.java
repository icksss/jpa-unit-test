import java.util.Date;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpastart.jpa.EMF;
import jpastart.reserve.model.User;

public class UserSaveMain {
    public static void main(String[] args) {
        EMF.init();
        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx = EMF.getTransaction();
        try{
            tx.begin();
            User user = new User("test@test.com", "test", new Date());
            // em.persist(user);
            // tx.commit();

            //조회
            User findUser = em.find(User.class, user.getEmail());
            // System.out.println(findUser);

            //수정
            // findUser.changeName("test2");
            
            // tx.commit();

            //삭제
            em.remove(findUser);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        EMF.close();
    }
}
