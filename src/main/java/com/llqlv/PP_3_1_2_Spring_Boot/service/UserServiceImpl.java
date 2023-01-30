package com.llqlv.PP_3_1_2_Spring_Boot.service;

import com.llqlv.PP_3_1_2_Spring_Boot.dao.UserDao;
import com.llqlv.PP_3_1_2_Spring_Boot.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private final UserDao userDAO;

    public UserServiceImpl(UserDao userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> showAllUsers() {
        return userDAO.showAllUsers();
    }

    @Override
    public User getUser(Long id) {
        return userDAO.getUser(id);
    }

    @Override
    @Transactional
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userDAO.delete(id);
    }

    @Override
    @Transactional
    public void update(User user) {
        userDAO.update(user);
    }


}