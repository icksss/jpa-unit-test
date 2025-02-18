import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpastart.jpa.EMF;
import jpastart.reserve.model.Notice;

public class NoticeMain {
    private static Logger logger = LoggerFactory.getLogger(NoticeMain.class);
    public static void main(String[] args) {
        EMF.init();
        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx = EMF.getTransaction();
        try{
           
            tx.begin();
            Notice notice = new Notice("공지사항", "공지사항 내용", true);
            em.persist(notice);
            tx.commit();
            // User user = new User("test@test.com", "test", new Date());
            // em.persist(user);
            // tx.commit();

            //조회
            Notice findNotice = em.find(Notice.class, notice.getId());
           logger.info("findNotice: {}", findNotice);
            // User findUser = em.find(User.class, user.getEmail());
            // System.out.println(findUser);

            //수정
            // findUser.changeName("test2");
            
            // tx.commit();

            //삭제
            // em.remove(findUser);
            // tx.commit();
        } catch (Exception e) {
            // tx.rollback();
            e.printStackTrace();
        } finally {
            // em.close();
        }
        // EMF.close();
    }

}
