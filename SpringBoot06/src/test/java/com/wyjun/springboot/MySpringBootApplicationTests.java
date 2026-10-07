package com.wyjun.springboot;

import com.wyjun.springboot.data.MyDataSource;
import com.wyjun.springboot.entity.*;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@SpringBootTest
class MySpringBootApplicationTests {

    @Autowired
    private UserBean userBean;

    @Resource
    private Customer customer;

    @Autowired
    private SpringBean springBean;

    @Autowired
    private MyDataSource myDataSource;

    @Resource
    private Person person;

    //注入环境对象
    @Autowired
    private Environment environment;

    @Test
    void contextLoads() {
        System.out.println(userBean);
        System.out.println(customer);
        System.out.println(springBean);
        System.out.println(myDataSource);
        System.out.println(person);
        System.out.println(environment);

        //通过环境变量，获取配置信息
        System.out.println(environment.getProperty("my.datasource.driver-class-name"));
        System.out.println(environment.getProperty("wyjun.info.name"));
        System.out.println(environment.getProperty("customer.info.address.city"));
        System.out.println(environment.getProperty("student.info.student-map.ID001.name"));
    }
}
//UserBean(id=1001, email=123456@qq.com, age=20)
//Customer(name=John, age=22, address=Address(City=Shanghai, street=Minhang))
//SpringBean(studentArray=[Student(name=Zhangsan, age=21), Student(name=Lisi, age=22)], studentList=[Student(name=Zhaoliu, age=23), Student(name=Qianqi, age=24)], studentMap={ID001=Student(name=John, age=25), ID002=Student(name=Lucy, age=26)}, studentArray2=[Student(name="Susan", age=31), Student(name="Smith", age=32)])
//MyDataSource(driverClassName=com.mysql.cj.jdbc.Driver, url=jdbc:mysql://localhost:3306/springboot, username=root, password=123456)
//Person(name=MrWang, country=China, province=Henan)

//ApplicationServletEnvironment {activeProfiles=[], defaultProfiles=[default], propertySources=[ConfigurationPropertySourcesPropertySource {name='configurationProperties'},
// MapPropertySource {name='test'}, MapPropertySource {name='Inlined Test Properties'}, StubPropertySource {name='servletConfigInitParams'}, ServletContextPropertySource {name='servletContextInitParams'},
// PropertiesPropertySource {name='systemProperties'}, OriginAwareSystemEnvironmentPropertySource {name='systemEnvironment'}, RandomValuePropertySource {name='random'},
// OriginTrackedMapPropertySource {name='Config resource 'class path resource [application.properties]' via location 'optional:classpath:/''},
// OriginTrackedMapPropertySource {name='Config resource 'class path resource [application.yml]' via location 'optional:classpath:/' (document #1)'},
// OriginTrackedMapPropertySource {name='Config resource 'class path resource [application.yml]' via location 'optional:classpath:/' (document #0)'},
// ApplicationInfoPropertySource {name='applicationInfo'}, ResourcePropertySource {name='class path resource [wyjun.properties]'}]}

//com.mysql.cj.jdbc.Driver
//MrWang
//Shanghai
//John