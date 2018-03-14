package com.zhc.admin.service.impl;

import com.zhc.admin.dao.UserDao;
import com.zhc.admin.pojo.User;
import com.zhc.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    /**
     * 自动注入持久层Dao对象
     */
    @Autowired
    private UserDao userDao;

    @Override
    public User login(String username) {
        return userDao.findByName(username);
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }
}
