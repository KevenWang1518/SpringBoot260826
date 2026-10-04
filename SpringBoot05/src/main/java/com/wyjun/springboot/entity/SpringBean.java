package com.wyjun.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpringBean {

    @Value("${email}")//获取application.yml中的email属性
    public String email;

    @Value("${CATALINA_HOME}")//获取操作系统环境变量中的CATALINA_HOME属性
    public String tomcatPath;

    @Value("${JAVA_HOME}")//获取操作系统环境变量中的JAVA_HOME属性
    public String jdkPath;

    @Value("${MAVEN_HOME}")//获取操作系统环境变量中的MAVEN_HOME属性
    public String mavenPath;

}
