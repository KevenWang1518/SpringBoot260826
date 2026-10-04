package com.wyjun.springboot03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Date;

/*
    SpringBoot核心注解:
        1. @Configuration
        3. @EnableAutoConfiguration
        2. @SpringBootConfiguration:使用 @SpringBootApplication标注的类就是一个配置类。
        4. @ComponentScan 注意:默认的组件扫描范围是springboot入口类所在的包以及子包。可以修改默认扫描范围。
*/
@SpringBootApplication
//注意：也可以写成@SpringBootApplication(scanBasePackages = {"com"})，则组件扫描范围从"com/wyjun/springboot03"扩大到"com"
public class SpringBoot03Application {

    // 配置类中可以写bean吗？
    // 是可以配置bean的，并且自动纳入IoC容器的管理。
    // 等同于我们以前写spring.xml文件时候的这样的配置:<bean id="date" class="java.util.Date"/>
    @Bean
    public Date date() {
        return new Date();
    }

    public static void main(String[] args) {

        //这个代码的作用就是初始化Spring的上下文，将所有的bean全部注册好。底层执行所有的自动配置。
        //SpringApplication.run(SpringBoot03Application.class, args);

        ConfigurableApplicationContext context = SpringApplication.run(SpringBoot03Application.class, args);//获取上下文
        Date date = context.getBean("date", Date.class);//使用bean
        System.out.println(date);//Sun Oct 04 16:06:15 CST 2026
    }

}
