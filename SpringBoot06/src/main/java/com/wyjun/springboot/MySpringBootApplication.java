package com.wyjun.springboot;

import com.wyjun.springboot.data.MyDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//这个注解代替的是对应类上的@Configuration(proxyBeanMethods = false)
//@EnableConfigurationProperties({Customer.class})//但是这种方式需要指定很多类，也很麻烦。
@ConfigurationPropertiesScan(basePackages = {"com.wyjun.springboot.entity"})//这样直接扫描包即可，不用指定很多类了。
public class MySpringBootApplication {

    @Bean //在不能访问源码的情况下，可以采用这种方式将properties/yml配置绑定到第三方对象。
    @ConfigurationProperties(prefix = "my.datasource")
    public MyDataSource myDataSource() {
        return new MyDataSource();
    }

    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApplication.class, args);
    }

}
