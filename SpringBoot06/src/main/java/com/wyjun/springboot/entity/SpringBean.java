package com.wyjun.springboot.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@Data
@ConfigurationProperties(prefix = "student.info")
public class SpringBean {
    //Array数组
    private Student[] studentArray;
    //List集合
    private List<Student> studentList;
    //Map集合
    private Map<String, Student> studentMap;

    //Array数组
    private Student[] studentArray2;
}
