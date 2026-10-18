package com.wyjun.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*第一种：编写类实现WebMvcConfigurer接口 + @Configuration，重写对应的方法。*/
// 通过写代码的方式，来完成SpringMVC的配置的扩展或者修改。
// 步骤:编一个类实现WebMvcConfigurer，然后将该类标注为配置类。
// 注意:不要添加 @EnableWebmvc注解(如果加上springboot默认配置全部失效。)
// 必须加上@Configuration注解，SpringBoot才会加载这个MVC配置，否则不会识别这个是配置类，自定义映射不生效！

@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {

    //自定义静态文件路径和文件夹
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //addResourceHandler("/mystatic/**")：代表浏览器 url 前缀是 /mystatic/
        //addResourceLocations("classpath:/mystatic/")：代表服务器内部去 "mystatic"文件夹读取资源
        //访问方式：http://localhost:8080/mystatic/test1.png
        registry.addResourceHandler("/mystatic/**").addResourceLocations("classpath:/mystatic/");
    }

    //配置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                System.out.println("preHandle method is running");
                return true;
            }

            @Override
            public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
                System.out.println("postHandle method is running");
            }

            @Override
            public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
                System.out.println("afterCompletion method is running");
            }
        });
    }
}
