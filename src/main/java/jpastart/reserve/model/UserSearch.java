// package jpastart.reserve.model;

// import java.util.List;

// import jakarta.persistence.EntityManager;
// import jakarta.persistence.TypedQuery;
// import jakarta.persistence.criteria.CriteriaBuilder;
// import jakarta.persistence.criteria.CriteriaQuery;
// import jakarta.persistence.criteria.Root;
// import jpastart.jpa.EMF;

// public class UserSearch {
//     public List<User> search(String name) {
//         EntityManager em = EMF.createEntityManager();
//         try {
//             CriteriaBuilder cb = em.getCriteriaBuilder();
//             CriteriaQuery<User> cq = cb.createQuery(User.class);
//             Root<User> root = cq.from(User.class);
//             cq.select(root).where(cb.like(root.<String>get("name"), "최%"));
//             TypedQuery<User> query = em.createQuery(cq);
//             List<User> users = query.getResultList();
//             return users;
//         } finally {
//             em.close();
//         }
//     }
// }