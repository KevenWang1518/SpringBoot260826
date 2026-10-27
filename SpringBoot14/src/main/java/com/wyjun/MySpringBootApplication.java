package com.wyjun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MySpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApplication.class, args);
        System.out.println("应用启动成功！");
        System.out.println("API文档地址：http://localhost:8080/doc.html");
        System.out.println("OpenAPI文档地址：http://localhost:8080/v3/api-docs");
    }
}
