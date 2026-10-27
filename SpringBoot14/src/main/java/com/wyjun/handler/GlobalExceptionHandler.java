package com.wyjun.handler;

import com.wyjun.entity.Result;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理 @RequestBody 参数校验异常
     *
     * @PostMapping public Result<User> createUser(
     * @Valid @RequestBody User user  // 这个注解触发的异常
     * )
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<Void> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        // 获取所有字段校验错误列表
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        // 创建列表用于存储所有错误提示信息
        List<String> errorMessages = new ArrayList<>();
        // 遍历每个字段校验错误
        for (FieldError fieldError : fieldErrors) {
            // 获取校验注解中定义的错误提示信息
            // 例如：@NotBlank(message="用户名不能为空") → "用户名不能为空"
            errorMessages.add(fieldError.getDefaultMessage());
        }
        String message = String.join("; ", errorMessages);
        return Result.error(400, message);
    }

    /**
     * 处理普通表单参数绑定异常,这个异常和校验框架无关。
     */
    @ExceptionHandler(BindException.class)
    public Result<Void> handleBindException(BindException e) {
        // 获取所有字段校验错误列表
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        // 创建列表存储所有错误信息
        List<String> errorMessages = new ArrayList<>();
        // 遍历每个字段错误，提取错误提示信息
        for (FieldError fieldError : fieldErrors) {
            String errorMessage = fieldError.getDefaultMessage();
            errorMessages.add(errorMessage);
        }
        String message = String.join("; ", errorMessages);
        return Result.error(400, message);
    }

    /**
     * 处理 @RequestParam/@PathVariable 参数校验异常
     *
     * @GetMapping("/{id}") public Result<User> getUser(
     * @PathVariable @Min(1) Long id,  // 这个注解触发的异常
     * @RequestParam @NotBlank String name  // 这个注解触发的异常
     * )
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public Result<Void> handleConstraintViolationException(ConstraintViolationException e) {
        // 获取所有校验失败的约束违规信息集合
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        // 创建列表用于存储所有错误信息
        List<String> errorMessages = new ArrayList<>();
        // 遍历每个违规信息，提取错误提示
        for (ConstraintViolation<?> violation : violations) {
            // 获取校验注解中的message信息，如"用户名不能为空"
            errorMessages.add(violation.getMessage());
        }
        // 将所有错误信息用分号连接成一个字符串
        String message = String.join("; ", errorMessages);
        // 返回400状态码和错误信息
        return Result.error(400, message);
    }

    /**
     * 处理运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    public Result<Void> handleRuntimeException(RuntimeException e) {
        return Result.error(e.getMessage());
    }


    /**
     * 处理其他异常
     */
    @ExceptionHandler(Exception.class)
    public Result<Void> handleException(Exception e) {
        return Result.error("系统异常: " + e.getMessage());
    }

    /*@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationException(MethodArgumentNotValidException ex) {

        Map<String, Object> errors = new HashMap<>();
        Map<String, String> fieldErrors = new HashMap<>();

        // 提取字段错误信息
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            fieldErrors.put(error.getField(), error.getDefaultMessage());
        });

        errors.put("code", 400);
        errors.put("message", "参数校验失败");
        errors.put("timestamp", System.currentTimeMillis());
        errors.put("errors", fieldErrors);

        return ResponseEntity.badRequest().body(errors);
    }*/
}