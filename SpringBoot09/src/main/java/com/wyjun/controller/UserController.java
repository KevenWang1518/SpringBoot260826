package com.wyjun.controller;

import com.wyjun.entity.User;
import com.wyjun.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//这里@RestController如果改用@Controller：则不会自动返回JSON，而且不写@ResponseBody就会去找页面
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor // 对应final属性
public class UserController {

    //IDEA 不推荐字段注入，原因：不方便单元测试、无法标记为 final、容易隐藏循环依赖问题。
    //@Autowired // 字段注入，去掉@Autowired的话，userService直接是null，访问接口空指针异常
    private final UserService userService;

    // 构造器注入（推荐写法，Spring 官方推荐）
    // 只有这一个构造函数，可以省略@Autowired
    // 这里加上@RequiredArgsConstructor的话，连下面的构造函数也不用写了，更方便。
    /* public UserController(UserService userService) {
        this.userService = userService;
    }*/

    @GetMapping("/select/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.selectUserById(id);
    }
    //测试路径 http://localhost:8080/user/select/1
    //{"id":1,"username":"ZhangSan","password":"123456","zipCode":"463001"}
}
