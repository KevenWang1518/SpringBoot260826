package com.wyjun.springboot.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
//@Configuration(proxyBeanMethods = false)
@ConfigurationProperties(prefix = "customer.info")
public class Customer {
    private String name;
    private Integer age;
    private Address address;
}
