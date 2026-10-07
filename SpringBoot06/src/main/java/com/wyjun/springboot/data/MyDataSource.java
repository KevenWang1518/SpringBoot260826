package com.wyjun.springboot.data;

import lombok.Data;

@Data
public class MyDataSource {
    private String driverClassName;
    private String url;
    private String username;
    private String password;
}
