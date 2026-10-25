package com.wyjun.controller;

import com.wyjun.entity.R;
import com.wyjun.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/detail")
    public R<User> detail() {
        User user = new User("1001", "ZhangSan");

        //成功，则返回一个R成功对象
        return R.OK("user detail information", user);

        //失败，则返回一个R失败对象。
        //return R.FAIL(400, "数据读取失败...");
    }
    //{
    //	"code": 200,
    //	"msg": "user detail information",
    //	"data": {
    //		"userId": "1001",
    //		"userName": "ZhangSan"
    //	}
    //}

    //{
    //	"code": 400,
    //	"msg": "数据读取失败...",
    //	"data": null
    //}
}
