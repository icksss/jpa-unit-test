import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpastart.jpa.EMF;
import jpastart.reserve.model.Choice;
import jpastart.reserve.model.Question;
import jpastart.reserve.model.RoleObject;

public class QuestionMain {    

    private static Logger logger = LoggerFactory.getLogger(QuestionMain.class);

    public static void main(String[] args) {
        EMF.init();
        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx = EMF.getTransaction();
        
        try{
            
            logger.info("QuestionMain 테스트 시작");
            Question question = new Question("What is the capital of France?");
            question.addChoice(new Choice("Paris", true));
            question.addChoice(new Choice("London", false));
            question.addChoice(new Choice("Berlin", false));
            tx.begin();
            em.persist(question);
            logger.info("question 저장");
            tx.commit();

            Question question2 = em.find(Question.class, question.getId());
            logger.info("question2: {}", question2);
            logger.info("QuestionMain 테스트 끝");
        }catch(Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally{
            em.close();
        }
        
    }   
}
