package com.wyjun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//SpringBoot的主入口程序。
@SpringBootApplication
public class MyApplication {
    public static void main(String[] args) {
        //这行代码固定的，用来启动容器。
        SpringApplication.run(MyApplication.class, args);
    }
}
