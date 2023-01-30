package com.llqlv.PP_3_1_2_Spring_Boot.dao;

import com.llqlv.PP_3_1_2_Spring_Boot.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


//import javax.persistence.Entity;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;


import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> showAllUsers() {
        return entityManager.createQuery("from User ", User.class).getResultList();
    }


    @Override
    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {
        entityManager.merge(user);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(getUser(id));
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }
}
