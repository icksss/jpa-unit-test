import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpastart.jpa.EMF;
import jpastart.reserve.model.Address;
import jpastart.reserve.model.Intro;
import jpastart.reserve.model.Writer;

public class WriterMain {    

    private static Logger logger = LoggerFactory.getLogger(WriterMain.class);

    public static void main(String[] args) {
        EMF.init();
        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx = EMF.getTransaction();
        
        try{
            Writer writer = new Writer("홍길동");
            
            writer.setIntro(new Intro("text", "안녕하세요"));
            writer.setAddress(new Address("서울", "강남", "12345"));
            tx.begin();
            em.persist(writer);
            logger.info("writer 저장");
            tx.commit();

            Writer writer2 = em.find(Writer.class, writer.getId());
            logger.info("writer2: {}", writer2);
        }catch(Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally{
            em.close();
        }
        
    }   
}
