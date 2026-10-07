package com.wyjun.springboot.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//底层会生成代理对象，但可以保证bean是单例的。
@Configuration(proxyBeanMethods = true)
//@Configuration(proxyBeanMethods = false)
public class MyConfig {
    @Bean
    A a() { return new A(); }

    @Bean
    B b() {
        A a1 = a();  // 第1次调用
        A a2 = a();  // 第2次调用
        System.out.println(a1 == a2);
        return new B();
    }
}
class A {}
class B {}