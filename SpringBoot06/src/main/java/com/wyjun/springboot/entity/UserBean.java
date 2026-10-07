package com.wyjun.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//下面这两个注解的作用:将配置文件中的配置一次性的绑定到这个bean上。
//@Component
//@ConfigurationProperties(prefix = "my-prefix")

//如果是一个配置类的话，建议使用 Configuration注解。语义化清晰，见名知义。
//单独使用它，底层会创建代理对象。
//@Configuration(proxyBeanMethods = true)//底层用代理，会生成代理对象，效率较低，可以保证bean是单例的。
@Configuration(proxyBeanMethods = false)//取消代理，底层不是代理对象，效率较高，无法保证bean是单例的。
@ConfigurationProperties(prefix = "my-prefix")//不管是写@Component还是@Configuration，这个不能省略。

@Data//生成setter getter方法。
@AllArgsConstructor
@NoArgsConstructor
public class UserBean {
    private Integer id;
    private String email;
    private Integer age;
}
