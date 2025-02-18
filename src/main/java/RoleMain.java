import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpastart.jpa.EMF;
import jpastart.reserve.model.GrantedPermission;
import jpastart.reserve.model.Role;
import jpastart.reserve.model.RoleObject;

public class RoleMain {    

    private static Logger logger = LoggerFactory.getLogger(RoleMain.class);

    public static void main(String[] args) {
        EMF.init();
        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx = EMF.getTransaction();
        
        try{
            logger.info("role Set 테스트 시작");
            Role role = new Role("admin");
            role.getPermissions().add("read");
            role.getPermissions().add("write");
            tx.begin();
            em.persist(role);
            logger.info("role 저장");
            tx.commit();

            Role Role2 = em.find(Role.class, role.getId());
            logger.info("Role2: {}", Role2);
            logger.info("role Set 테스트 끝");


            logger.info("roleObject Set 테스트 시작");
            RoleObject roleObject = new RoleObject("admin");
            roleObject.getPermissions().add(new GrantedPermission("read", "admin"));
            roleObject.getPermissions().add(new GrantedPermission("write", "admin"));
            tx.begin();
            em.persist(roleObject);
            logger.info("roleObject 저장");
            tx.commit();

            RoleObject roleObject2 = em.find(RoleObject.class, roleObject.getId());
            logger.info("roleObject2: {}", roleObject2);
            logger.info("roleObject Set 테스트 끝");
        }catch(Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally{
            em.close();
        }
        
    }   
}
