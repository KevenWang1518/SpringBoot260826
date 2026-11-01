package com.wyjun.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_car")
//MP的注解:指定表名和实体类的映射关系。
//如果数据库表的名字是car，实体类的名字是Car，则不需要这个注解。
//如果数据库表的名字是car_info，实体类的名字是CarInfo，同样也不需要使用这个注解。
//数据库表名和实体类的名字无法自动转换(下划线转驼峰)，无法自动对应，需要使用@TableName(“在这里指定表名”)。
public class Car {
    //当实体类中有id属性的话，id属性自动会和数据库表中的主键字段映射。
    //当实体类中的属性名是id，数据库表中主键字段的名字正好也是id。这个@TableId 可以省略。
    //@TableId 的核心作用:标记主键。
    //官方建议:只要你属性名不是id，最好都使用上@TableId注解(即使属性名和字段名能对应上，写上起码可读性强，而且还可以指定主健生成策略)
    //关于主键的生成策略:
    //1.IdType.AUTO:使用数据库自增 ID 作为主键。前提是:数据库表中的字段在创建表的时候已经指定了auto_increment
    //2.IdType.ASSIGN_ID:自动分配 ID，适用于 Long. Integer、String 炎型的键。默认使用花算法通过 IdentifierGenerator 的 nextId 实现.
    //  当没有指定主键生成策略时，即使数据库表中的主键上有auto_increment，它也只是走雪花算法生成ID。
    //3.IdType.ASSIGN_UUID:自动分配 UUID,适用于 String 类型的主键。默认实现为 IdentifierGenerator的nextUUID 方法
    //  使用这种主键生成策略的时候，实体类的属性类型需要是String。
    //4.IdType.INPUT:在插入数据前，由用户自行设置主键值。
    //5.IdType.NONE:无特定生成策略，如果全局配置中有IdType 相关的配置，则会跟随全局配置。
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    //属性名和字段名也是通过下划线转驼峰的方式进行自动映射。
    private String carNum;
    private String brand;
    private Double guidePrice;
    private String produceTime;
    private String carType;
}