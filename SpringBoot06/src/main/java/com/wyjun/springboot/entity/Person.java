package com.wyjun.springboot.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
@ConfigurationProperties(prefix = "wyjun.info")
@PropertySource(value = "classpath:/wyjun.properties")
public class Person {
    private String name;
    private String country;
    private String province;
}
