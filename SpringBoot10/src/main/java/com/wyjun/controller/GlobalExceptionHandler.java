package com.wyjun.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//也可以把以上局部生效的方法单独放到一个类当中，这个类使用@ControllerAdvice注解标注。
//凡是任何控制器当中出现了对应的异常，则走这个方法来进行异常的处理。全局生效。
//将之前的局部处理方案的代码注释掉。使用全局处理方式。

@ControllerAdvice  // 或者直接使用RestControllerAdvice，那么@ResponseBody可以省略
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public String handler(IllegalArgumentException e){
        return "全局的错误信息：" + e.getMessage();
    }
}
