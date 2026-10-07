package com.wyjun.entity;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vip {
    private Long id;
    private String name;
    private String cardNumber;
    private String birth;
}
