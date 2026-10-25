package com.wyjun.bean;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 通过该注解可以定制XML根节点的名字，如果不需要定制，这个注解可以去掉。
@JacksonXmlRootElement(localName = "UserInfo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String userId;
    private String userName;
}
