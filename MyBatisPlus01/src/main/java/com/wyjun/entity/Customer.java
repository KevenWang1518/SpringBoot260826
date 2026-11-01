package com.wyjun.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tbl_customer")
public class Customer {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("username") //属性名和字段名不一致，对应不上，需要添加这个注解。
    private String name;// 姓名

    @TableField("is_vip")// 是布尔类型并且属性名以is开头
    private Boolean isVip;// 是否会员

    @TableField("'desc'")//desc是数据库中的关键字
    private String desc;// 简单描述

    @TableField(exist = false)//数据库表中没有这个字段，需要添加这个注解。
    private String createTime;// 创建时间
}