package com.wyjun;

import com.wyjun.bean.A;
import com.wyjun.bean.B;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

//SpringBoot的主入口程序。
@SpringBootApplication
public class MyApplication {
    public static void main(String[] args) {
        //这行代码固定的，用来启动容器。
        //SpringApplication.run(MyApplication.class, args);

        ConfigurableApplicationContext context = SpringApplication.run(MyApplication.class, args);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        System.out.println(beanDefinitionNames.length); //166

        //获取A和B两个Bean
        A aBean = context.getBean(A.class);
        System.out.println(aBean);

        B bBean = context.getBean(B.class);
        System.out.println(bBean);

    }
}
