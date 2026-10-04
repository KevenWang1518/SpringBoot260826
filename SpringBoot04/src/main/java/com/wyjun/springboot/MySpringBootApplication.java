package com.wyjun.springboot;

import com.wyjun.springboot.entity.SpringBean;
import com.wyjun.springboot.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

//不使用单元测试，如何调用service方法？采用获取bean的方式
@SpringBootApplication
public class MySpringBootApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MySpringBootApplication.class, args);
        UserService userService = context.getBean(UserService.class);
        userService.save();

        SpringBean springBean = context.getBean(SpringBean.class);
        System.out.println(springBean);
    }
}
