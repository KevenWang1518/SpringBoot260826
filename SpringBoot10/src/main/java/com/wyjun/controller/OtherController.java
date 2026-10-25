package com.wyjun.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//这里再编写一个OtherController，让它也发生IllegalArgumentException异常，看看它会不会走局部的错误处理机制。
//通过测试，确实局部生效。
@RestController
public class OtherController {
    @GetMapping("/resource2/{id}")
    public String getResource(@PathVariable Long id){
        if(id == 1){
            throw new IllegalArgumentException("无效ID：" + id);
        }
        return "ID = " + id;
    }

    @GetMapping("/resource3/{id}")
    public String getErrorMsg(@PathVariable Long id){
        if(id == 1){
            throw new NullPointerException("空指针异常：ID：" + id);//500错误
        }
        return "ID = " + id;
    }
}
