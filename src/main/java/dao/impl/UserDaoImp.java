package dao.impl;

import dao.UserDAO;
import model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDAO {

    @PersistenceContext
    EntityManager entityManager;
    @Transactional
    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public User findUserToID(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(Long id) {
       User user = findUserToID(id);
        entityManager.remove(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public List<User> getUserList() {
        return entityManager.createQuery("from User",User.class).getResultList();
    }
}
