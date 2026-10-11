package com.wyjun.bean;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//当类路径当中存在DispatcherServlet类，则启用配置，反之则不启用配置，
@ConditionalOnClass(name = {"org.springframework.web.servlet.DispatcherServlet"})

//注意：@ConditionalOnClass才有name属性，@ConditionalOnMissingClass只有value属性。
//@ConditionalOnMissingClass(value = {"org.springframework.web.servlet.DispatcherServlet"})
@Configuration
public class AppConfig {

    @Bean
    public A a(){
        return new A();
    }

    @ConditionalOnBean(A.class)
    @Bean
    public B b(){
        return new B();
    }

    @ConditionalOnMissingBean(A.class)
    @Bean
    public C c(){
        return new C();
    }
}