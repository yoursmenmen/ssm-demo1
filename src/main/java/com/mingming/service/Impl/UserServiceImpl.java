package com.mingming.service.Impl;

import com.mingming.controller.Code;
import com.mingming.dao.UserDao;
import com.mingming.exception.SystemException;
import com.mingming.pojo.User;
import com.mingming.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户服务impl
 *
 * @author h
 * @date 2022/08/12
 */
@Service

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean save(User user) {
        userDao.save(user);
        return true;
    }

    @Override
    public boolean update(User user) {
        userDao.update(user);
        return true;
    }

    @Override
    public boolean delete(int id) {
        userDao.delete(id);
        return true;
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }

    @Override
    public String getProvince(int id) {
        return userDao.getProvince(id);
    }

    @Override
    public User login(String username, String password) {
        return userDao.login(username, password);
    }

    @Override
    public User selectByUsername(String username) {
        return userDao.selectByUsername(username);
    }



}
