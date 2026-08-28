package com.wyjun.springboot03.controller;

import com.wyjun.springboot03.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/detail")
    public User detail() {
        return new User("jack", "123");
    }
}