package com.wyjun.entity;

import lombok.Builder;
import lombok.Singular;
import lombok.ToString;

import java.util.List;

@Builder //这个注解可以帮我们生成建造者模式的代码。
@ToString
public class Customer {
    private String name;
    private Integer age;
    private String email;
    //当被建造的对象的属性是一个集合，这个集合属性使用@Singular注解进行标注的话，可以连续调用集合属性对应的方法完成多个元素的添加。如果没有这个注解，则无法连续调用方法完成多个元素的添加。
    @Singular("addPhone")//注意@Singular注解后面一定要添加上名字
    private List<String> phones;

    public static void main(String[] args) {
        Customer customer1 = Customer.builder().name("John").age(22).email("john@sina.com").build();
        System.out.println(customer1);

        Customer customer2 = Customer.builder().name("Lucy").age(23).email("lucy@sina.com").addPhone("133303960396").addPhone("13503960396").build();
        System.out.println(customer2);
    }
    //Customer(name=John, age=22, email=john@sina.com, phones=[])
    //Customer(name=Lucy, age=23, email=lucy@sina.com, phones=[133303960396, 13503960396])
}
