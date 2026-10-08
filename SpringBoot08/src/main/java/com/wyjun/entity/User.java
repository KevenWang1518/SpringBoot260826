package com.wyjun.entity;

public class User {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    private User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public User() {
    }

    public static UserBuilder userBuilder() {
        return new UserBuilder();
    }

    public static class UserBuilder {
        private String name;
        private Integer age;

        public UserBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder age(Integer age) {
            this.age = age;
            return this;
        }

        public User build() {
            return new User(name, age);
        }
    }

    public static void main(String[] args) {
        User user = User.userBuilder().name("Wangwu").age(23).build();
        System.out.println(user);
    }
}
