package jpastart.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpastart.jpa.EMF;
import jpastart.reserve.model.Review;

public class ReviewService {
    private static final Logger logger = LoggerFactory.getLogger(ReviewService.class);
    public void register(Review review){
        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx = EMF.getTransaction();
        try{
            tx.begin();
            em.persist(review);
            tx.commit();
            logger.info("review.getId : {} ", review.getId());
        }catch(Exception e){
            tx.rollback();
            throw e;
        }finally{
            em.close();
        }

        
    }
}
