package web.repositories;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
@Transactional(readOnly = true)
public class UserRepositoryImp implements UserRepository {



    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> index() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User show(int id) {
        return entityManager.find(User.class, id);

    }

    @Transactional
    public void save(User person) {
        entityManager.persist(person);
    }

    @Override
    @Transactional

    public void update(int id, User user) {
        User user1 = entityManager.find(User.class, id);
        if (user1 != null) {
            user1.setEmail(user.getEmail());
            user1.setAge(user.getAge());
            user1.setName(user.getName());
            entityManager.merge(user);

        }

    }



    @Override
    @Transactional
    public void delete(int id) {
        User person = entityManager.find(User.class, id);
        if (person != null) {
            entityManager.remove(person);
        }
    }
}
