package com.zhc.admin.service;

import com.zhc.admin.pojo.User;

public interface UserService {
    /**
     * 用户登录
     * @param  username
     * @return User对象
     * */
    User login(String username);

    /**
     * @Author : zhc
     * @Decription: 保存用户
     * @param user
     * @return :
     * @Date : 10:53 2017/12/27 0027
     */
    void save(User user);
}
