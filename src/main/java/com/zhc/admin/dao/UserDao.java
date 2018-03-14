package com.zhc.admin.dao;

import com.zhc.admin.pojo.User;

public interface UserDao {

    public void save(User user);

    public User findByName(String username);
}
