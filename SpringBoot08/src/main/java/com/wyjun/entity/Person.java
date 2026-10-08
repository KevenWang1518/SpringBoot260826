package com.wyjun.entity;

// 建造者模式
public class Person {
    private String name;
    private Integer age;
    private String email;

    // 私有的全参数构造方法
    private Person(String name, Integer age, String email){
        this.name = name;
        this.age = age;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }

    // 获取建造者对象，这是外部Person类的静态方法，类名直接调用。
    public static PersonBuilder builder(){
        return new PersonBuilder();
    }

    // 一般会提供一个静态的内部类：建造者类
    public static class PersonBuilder {
        private String name;
        private Integer age;
        private String email;
        public PersonBuilder name(String name){
            this.name = name;
            return this;
        }
        public PersonBuilder age(Integer age){
            this.age = age;
            return this;
        }
        public PersonBuilder email(String email){
            this.email = email;
            return this;
        }
        // 核心代码：建造方法
        // 建造者最终是要建造一个对象，Person对象。
        public Person build(){
            return new Person(name, age, email);
        }
    }

    public static void main(String[] args) {
        Person person = Person.builder()
                .name("Zhangsan")
                .age(22)
                .email("Zhangsan@sina.com")
                .build();
        System.out.println(person);
    }
}
