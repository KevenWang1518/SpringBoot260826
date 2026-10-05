package com.wyjun.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpringBean {

    @Value("${email}")//获取application.yml中的email属性
    public String email;

    @Value("${names1}")//获取application.yml中的names1属性
    public String[] names1;

    @Value("${names2}")//获取application.yml中的names2属性
    public List<String> names2;

    @Value("${myapp.name}")//获取application.yml中的myapp.name属性
    public String appName;

    @Value("${myapp.build}")//获取application.yml中的myapp.build属性
    public String appBuild;

    @Value("${CATALINA_HOME}")//获取操作系统环境变量中的CATALINA_HOME属性
    public String tomcatPath;

    @Value("${JAVA_HOME}")//获取操作系统环境变量中的JAVA_HOME属性
    public String jdkPath;

    @Value("${MAVEN_HOME}")//获取操作系统环境变量中的MAVEN_HOME属性
    public String mavenPath;

    @Value("${spring.datasource.username}")//获取不同properties文件中的属性
    private String username;
    @Value("${spring.datasource.password}")//获取不同properties文件中的属性
    private String password;
    @Value("${spring.data.redis.host}")//获取不同properties文件中的属性
    private String host;
    @Value("${spring.data.redis.port}")//获取不同properties文件中的属性
    private String port;

}
