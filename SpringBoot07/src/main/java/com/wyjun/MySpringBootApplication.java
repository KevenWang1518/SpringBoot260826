package com.wyjun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(basePackages = "com.wyjun.mapper")//启动类上加@MapperScan，接口上不用写 @Mapper
//扫描mapper包下所有接口,加上之后Mapper接口上不用写@Mapper注解，所有Mapper自动扫描。
public class MySpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApplication.class, args);
    }

}
