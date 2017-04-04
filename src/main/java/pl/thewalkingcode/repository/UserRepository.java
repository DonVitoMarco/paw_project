package pl.thewalkingcode.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.thewalkingcode.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Repository
public class UserRepository {

    private EntityManagerFactory entityManagerFactory;

    @Autowired
    public UserRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public User createUser(User user) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.persist(user);
        em.flush();
        return user;
    }

}