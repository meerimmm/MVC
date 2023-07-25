package peaksoft.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import peaksoft.model.User;
import peaksoft.service.ServiceLayer;

import java.util.List;
@Service
public class UserServiceImpl implements ServiceLayer<User> {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public User findById(int id) {
return  entityManager.find(User.class,id);
    }

    @Override
    public List<User> findAll() {
        return (List<User>)entityManager.createQuery("from User").getResultList();
    }

    @Override
    public User save(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public User updateById(int id, User user) {
        User oldUser=entityManager.find(User.class,id);
        oldUser.setName(user.getName());
        return oldUser;
    }

    @Override
    public void deleteById(int id) {

    }
}
