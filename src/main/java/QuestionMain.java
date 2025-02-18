
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jpastart.jpa.EMF;
import jpastart.reserve.model.Choice;
import jpastart.reserve.model.Question;

public class QuestionMain {    

    private static Logger logger = LoggerFactory.getLogger(QuestionMain.class);

    public static void main(String[] args) {
        EMF.init();
        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx = EMF.getTransaction();
        
        try{
            
            // logger.info("QuestionMain 테스트 시작");
            // Question question = new Question("질문이 많으면 안되222?");
            // question.addChoice(new Choice("응2", true));
            // question.addChoice(new Choice("아니2", false));
            // question.addChoice(new Choice("몰라2", false));
            // // question.addChoice(new Choice("Paris", true));
            // // question.addChoice(new Choice("London", false));
            // // question.addChoice(new Choice("Berlin", false));
            // tx.begin();
            // em.persist(question);
            // logger.info("question 저장");
            // tx.commit();

            // Question question2 = em.find(Question.class, question.getId());
            // logger.info("question2: {}", question2);
            // logger.info("QuestionMain 테스트 끝");

            logger.info("QuestionMain JPQL 테스트 시작");
            TypedQuery<Question> query = em.createQuery("select q from Question q", //"select q from Question q where q.id = :id"
                                                        Question.class);
            // query.setParameter("id", 1);
            query.setFirstResult(1);
            query.setMaxResults(2);
            List<Question> questions = query.getResultList();
            for(Question q : questions){
                logger.info("question: {}", q);
            }
            logger.info("QuestionMain JPQL 테스트 끝");

            logger.info("QuestionMain Criteria 테스트 시작");
            //1.builder 생성
            //2.Query 생성
            //3.Entity 지정
            //4.select 절 지정
            //5.from 절 지정
            //6.where 절 지정
            //7.orderBy 절 지정
            //8.limit 지정
            //9.offset 지정
            //10.getResultList 호출
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Question> cq = cb.createQuery(Question.class);
            Root<Question> root = cq.from(Question.class);
            cq.select(root);
            Predicate predicate1 = cb.equal(root.<Integer>get("id"), 1);
            Predicate predicate2 = cb.equal(root.<Integer>get("id"), 2);
            Predicate predicate = cb.or(predicate1, predicate2);
            cq.where(predicate);

            // cq.where(cb.equal(root.get("id"), 1));
            TypedQuery<Question> query2 = em.createQuery(cq);
            List<Question> questions2 = query2.getResultList();
            for(Question q : questions2){
                logger.info("question: {}", q);
            }
            logger.info("QuestionMain Criteria 테스트 끝");

        }catch(Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally{
            em.close();
        }
        
    }   
}
