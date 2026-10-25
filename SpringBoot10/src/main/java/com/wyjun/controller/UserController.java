package com.wyjun.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/resource/{id}")
    public String getResource(@PathVariable Long id) {
        if (id == 1) {
            throw new IllegalArgumentException("无效ID：" + id);
        }
        return "ID = " + id;
    }

    // 在控制器当中编写一个方法，方法使用@ExceptionHandler注解进行标注，凡是这个控制器当中出现了对应的异常，则走这个方法来进行异常的处理(局部生效)。
    // 这是springMvc的局部异常处理机制。只作用于 UserController，不是全局的。
    @ExceptionHandler(IllegalArgumentException.class)
    public String handler(IllegalArgumentException e) {
        return "局部的错误信息：" + e.getMessage();
    }
}
