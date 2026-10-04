package com.wyjun.springboot.service.impl;

import com.wyjun.springboot.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void save() {
        System.out.println("正在保存用户信息...");
    }
}
