package com.wyjun.controller;

import com.wyjun.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

// 注意：不能使用 @RestController
// 用 Thymeleaf 的控制器注解是 @Controller，不是@RestController
// @RestController：返回 JSON，不找页面
// @Controller：默认找视图（页面模板），配合 Thymeleaf

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String helloThymeleaf(@RequestParam("name") String name, Model model) {
        // 将接收到的name数据存储到域对象中
        model.addAttribute("name", name);
        // 逻辑视图名
        return "hellothymeleaf"; // 最终寻找的物理视图名：classpath:/templates/hellothymeleaf.html
    }
    //浏览器访问路径：http://localhost:8080/hello?name=zhangsan
    //hello,zhangsan

    @GetMapping("/detail/{userId}/{userName}")
    public String detailThymeleaf(@PathVariable("userId") String id, @PathVariable("userName") String name, Model model) {
        // 将接收到的name数据存储到域对象中
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        model.addAttribute("userBean", new User("1002", "Lucy"));

        // 逻辑视图名
        return "detailthymeleaf"; // 最终寻找的物理视图名：classpath:/templates/detailthymeleaf.html
    }
    //浏览器访问路径：http://localhost:8080/detail/1001/zhangsan
    //hello,1001
    //hello,zhangsan
    //hello,1002
    //hello,Lucy
    //hello,1002
    //hello,Lucy
}