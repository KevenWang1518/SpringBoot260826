package com.wyjun;

import com.wyjun.service.AsyncService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
//启用异步方法支持
@EnableAsync
public class MySpringBootApplication {

    public static void main(String[] args) {
        // run返回Spring容器上下文
        ConfigurableApplicationContext context = SpringApplication.run(MySpringBootApplication.class, args);
        // 从容器中取出bean调用
        AsyncService asyncService = context.getBean(AsyncService.class);
        asyncService.doTask();
    }
}
