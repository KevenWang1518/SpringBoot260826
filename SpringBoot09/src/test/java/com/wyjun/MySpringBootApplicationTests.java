package com.wyjun;

import com.wyjun.controller.UserController;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//小提醒：UserMapper接口，要么加@Mapper注解，要么在启动类上加@MapperScan("com.wyjun.mapper")，否则Spring找不到UserMapper这个Bean，启动报错。
@SpringBootTest
@MapperScan(basePackages = "com.wyjun.mapper")
class MySpringBootApplicationTests {

    @Autowired
    private UserController userController;

    @Test
    void contextLoads() {
        System.out.println(userController.getUserById(1L));
        System.out.println(userController.getUserById(2L));
        System.out.println(userController.getUserById(3L));
    }
}
