package com.itheima.service;

import com.itheima.pojo.User;

public interface UserService {

    /**
     * 登录方法，查询用户对象
     * @param username
     * @param password
     * @return
     */
    User login(String username, String password);

    User checkUsername(String username);

    boolean add(User user);
}
