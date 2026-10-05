package com.wyjun.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//下面这两个注解的作用:将配置文件中的配置一次性的绑定到这个bean上。
@Component
@ConfigurationProperties(prefix = "my-prefix")
@Data//生成setter getter方法。
@AllArgsConstructor
@NoArgsConstructor
public class UserBean {
    private Integer id;
    private String email;
    private Integer age;
}
