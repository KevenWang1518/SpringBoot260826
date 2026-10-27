package com.wyjun.controller;

import com.wyjun.entity.Result;
import com.wyjun.entity.User;
import com.wyjun.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
// @Tag 注解用于给 Controller 分类，在 Knife4j 文档中将相关的接口归为一组，方便前端开发者快速查找。
@Tag(name = "用户管理", description = "用户相关的CRUD操作")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    // 为API接口添加详细的描述信息，包括接口摘要和详细说明
    @Operation(summary = "创建用户", description = "添加一个新用户")
    public Result<User> createUser(
            // 描述API接口中的单个参数，包括参数说明、是否必需、示例值等信息
            @Parameter(description = "用户信息", required = true)
            @Valid @RequestBody User user) {
        User savedUser = userService.addUser(user);
        return Result.success(savedUser, "创建成功");
    }

    @PutMapping
    @Operation(summary = "更新用户", description = "更新用户信息")
    public Result<User> updateUser(
            @Parameter(description = "用户信息", required = true)
            @Valid @RequestBody User user) {
        User updatedUser = userService.updateUser(user);
        return Result.success(updatedUser, "更新成功");
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除用户", description = "根据ID删除用户")
    public Result<Void> deleteUser(
            @Parameter(description = "用户ID", required = true, example = "1")
            @PathVariable Long id) {
        boolean success = userService.deleteUser(id);
        if (success) {
            return Result.success(null, "删除成功");
        } else {
            return Result.error("用户不存在");
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "获取用户详情", description = "根据ID查询用户")
    public Result<User> getUserById(
            @Parameter(description = "用户ID", required = true, example = "1")
            @PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return Result.success(user);
        } else {
            return Result.error(404, "用户不存在");
        }
    }

    @GetMapping
    @Operation(summary = "获取所有用户", description = "查询所有用户列表")
    public Result<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return Result.success(users);
    }

    @GetMapping("/search")
    @Operation(summary = "搜索用户", description = "根据用户名搜索用户")
    public Result<List<User>> searchUsers(
            @Parameter(description = "用户名关键字", required = true, example = "张三")
            @RequestParam String username) {
        List<User> users = userService.getUsersByUsername(username);
        return Result.success(users);
    }
}