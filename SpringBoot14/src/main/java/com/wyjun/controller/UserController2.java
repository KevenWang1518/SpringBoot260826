package com.wyjun.controller;

import com.wyjun.dto.UserCreateDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController2 {

    // @Valid 启用校验的注解。
    @PostMapping("/createuser")
    @Operation(summary = "创建用户")
    @ApiResponse(responseCode = "201", description = "创建成功")
    public UserCreateDTO createUser(@Valid @RequestBody UserCreateDTO userCreateDTO) {
        //  假如校验失败，系统自动抛出异常报错，根本不会走到return这里
        return userCreateDTO;
    }
}
