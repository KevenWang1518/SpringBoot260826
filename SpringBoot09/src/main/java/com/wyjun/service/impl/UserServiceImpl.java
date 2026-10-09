package com.wyjun.service.impl;

import com.wyjun.entity.User;
import com.wyjun.mapper.UserMapper;
import com.wyjun.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // 这个注解把UserServiceImpl交给Spring管理。
@RequiredArgsConstructor // 对应final属性
public class UserServiceImpl implements UserService {

    //IDEA 不推荐字段注入，原因：不方便单元测试、无法标记为 final、容易隐藏循环依赖问题。
    //@Autowired // 字段注入，去掉@Autowired的话，userService直接是null，访问接口空指针异常
    private final UserMapper userMapper;

    // 只有这一个构造函数，Spring自动注入，不用写@Autowired
    // 这里加上@RequiredArgsConstructor的话，连下面的构造函数也不用写了，更方便。
    /*public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }*/

    @Override
    public User selectUserById(long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
