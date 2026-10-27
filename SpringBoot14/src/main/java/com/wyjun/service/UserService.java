package com.wyjun.service;

import com.wyjun.entity.User;

import java.util.List;

public interface UserService {

    /**
     * 添加用户
     */
    User addUser(User user);

    /**
     * 更新用户
     */
    User updateUser(User user);

    /**
     * 删除用户
     */
    boolean deleteUser(Long id);

    /**
     * 根据ID查询用户
     */
    User getUserById(Long id);

    /**
     * 查询所有用户
     */
    List<User> getAllUsers();

    /**
     * 根据用户名查询用户
     */
    List<User> getUsersByUsername(String username);
}