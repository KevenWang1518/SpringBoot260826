package com.wyjun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/* 第二种：编写一个方法，用@Bean注解标注。*/
// 建议采用第一种实现类的方式：因为这种Bean方式可能产生大量的bean。
@Configuration
public class MyWebMvcConfig2 {
    @Bean //采用@Bean注解提供一个WebMvcConfigurer组件。
    public WebMvcConfigurer addResourceHandlers(){
        return new WebMvcConfigurer() {
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                //访问方式：http://localhost:8080/mystatic2/test3.png
                registry.addResourceHandler("/mystatic2/**").addResourceLocations("classpath:/mystatic2/");
            }
        };
    }
}
