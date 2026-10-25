package com.wyjun.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController //相当于 @Controller + @ResponseBody
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello SpringBoot";//因为有@ResponseBody，这里会走消息转换器，不会走逻辑视图名了。
    }

    //web的请求路径支持模糊匹配（正则表达式路径匹配）
    @GetMapping("/{path:[a-z]+}/a?/*.do/**")
    public String hello2(HttpServletRequest request, @PathVariable("path") String myPath){
        return request.getRequestURI() + "," + myPath;
    }
    //访问路径：http://localhost:8080/abc/ab/test.do/111/222/333
    //浏览器显示：/abc/ab/test.do/111/222/333,abc
}
