import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpastart.jpa.EMF;
import jpastart.reserve.model.AccessLog;

public class AccessLogMain {
    public static void main(String[] args) {
        EMF.init();
        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx = EMF.getTransaction();
        
        try{
            AccessLog accessLog = new AccessLog("/accesslog");
            tx.begin();
            em.persist(accessLog);
            tx.commit();
        }catch(Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally{
            em.close();
        }
        
    }   
}
