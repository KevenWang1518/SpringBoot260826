package com.wyjun.entity;

import lombok.Data;

/**
 * 
 * @TableName t_user
 */
@Data
public class User {
    /**
     * user's id
     */
    private Integer id;

    /**
     * user's name
     */
    private String username;

    /**
     * user's password
     */
    private String password;

    /**
     * user's zipcode
     */
    private String zipCode;
}