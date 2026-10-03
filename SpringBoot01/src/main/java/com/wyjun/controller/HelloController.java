package com.wyjun.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //相当于 @Controller + @ResponseBody
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello SpringBoot";//因为有@ResponseBody，这里会走消息转换器，不会走逻辑视图名了。
    }
}
