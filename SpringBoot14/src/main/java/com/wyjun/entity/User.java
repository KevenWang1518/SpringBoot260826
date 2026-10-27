package com.wyjun.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

//swagger生成API接口文档中对实体类有描述。因此实体类和实体类中的字段都要添加 @Schema注解进行描述。
@Data
@NoArgsConstructor
@AllArgsConstructor
/*
@Schema 注解用于为 API 文档中的模型类及其字段添加描述、示例、
是否必填等元数据信息，从而生成更清晰、易用的接口文档。
为整个实体类添加描述信息。
在Swagger文档中会显示“用户实体"作为这个模型的描述。
在API文档的“实体类列表“或“模型"部分会显示这个描述。
 */
@Schema(description = "用户实体")
public class User {

    @Schema(description = "用户ID", example = "1")
    private Long id;

    @NotBlank(message = "用户名不能为空")
    /*
    description: 字段的描述信息
        会在API文档中显示字段的说明
        方便前端开发者理解字段含义
    example: 示例值
        在API文档中提供示例数据
        测试时会自动填充这个值
        有助于理解字段的格式和类型
    required: 是否必需
        required = true 表示该字段在请求中必须提供
        在文档中会标注为必填字段
        注意: 这只是文档层面的标注，实际校验需要配合 @NotNull、@NotBlank 等注解
     */
    @Schema(description = "用户名", example = "张三", required = true)
    private String username;

    @NotBlank(message = "密码不能为空")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$",
            message = "密码必须包含字母和数字，且长度至少6位")
    @Schema(description = "密码", example = "123456a", required = true)
    private String password;

    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    @Schema(description = "邮箱", example = "zhangsan@example.com", required = true)
    private String email;

    @NotNull(message = "年龄不能为空")
    @Schema(description = "年龄", example = "25", required = true)
    private Integer age;

    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^1[3-9]\\d{9}$", message = "手机号格式不正确")
    @Schema(description = "手机号", example = "13800138000", required = true)
    private String phone;

    @Schema(description = "创建时间", example = "2024-01-01 10:00:00")
    /*
        这个注解和swagger无关，属于jackson库中的注解。作用是指定日期对象在序列化和反序列化时的日期格式。
        不指定@JsonFormat时，LocalDateTime会默认序列化为包含"T"的ISO-8601格式（如"2024-01-01T10:00:00"）
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @Schema(description = "更新时间", example = "2024-01-01 10:00:00")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}