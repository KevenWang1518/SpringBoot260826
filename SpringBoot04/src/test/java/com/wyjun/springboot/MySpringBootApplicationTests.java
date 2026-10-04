package com.wyjun.springboot;

import com.wyjun.springboot.service.UserService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

//这个注解很关键，相当于执行了SpringApplication.run(MySpringBootApplication.class, args) 获取到了context;
@SpringBootTest
class MySpringBootApplicationTests {

    @Autowired //在单元测试中使用某个bean可以直接注入
    @Qualifier("userServiceImpl")   // Autowired：按类型注入（Spring框架自带注解）
    private UserService userService;

    // @Resource // 也可以使用@Resource：优先byName，byName失败再byType（Java官方标准注解，JDK自带，不是Spring独有的）
    //private UserService userService;

    @Test
    void contextLoads() {
        userService.save();
    }
}
