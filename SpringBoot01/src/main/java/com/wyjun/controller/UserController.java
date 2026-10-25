package com.wyjun.controller;

import com.wyjun.bean.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user/detail")
    public User detail() {
        //返回 json 或者 xml
        return new User("1001", "Smith");
    }
    //json:
    // {
    //	"userId": "1001",
    //	"userName": "Smith"
    // }

    //xml：
    // <User>
    //    <userId>1001</userId>
    //    <userName>Smith</userName>
    // </User>
}
