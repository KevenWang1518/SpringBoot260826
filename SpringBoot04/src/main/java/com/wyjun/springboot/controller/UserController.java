package com.wyjun.springboot.controller;

import com.wyjun.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    public UserService userService; //注入接口，Spring自动找它的实现类UserServiceImpl

    @GetMapping("/usersave")
    public String userSave() {
        return "save user success";
    }
}
