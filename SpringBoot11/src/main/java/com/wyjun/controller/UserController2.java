package com.wyjun.controller;

import com.wyjun.entity.R;
import com.wyjun.entity.R2;
import com.wyjun.entity.User;
import com.wyjun.enums.CodeEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController2 {

    @GetMapping("/detail2")
    public R2<User> detail2() {
        User user = new User("1002", "Lucy");

        //成功，则返回一个R2成功对象
        //return R2.OK(user);

        //失败，则返回一个R2失败对象。
        //return R2.FAIL();

        //创建失败，则返回一个R2创建失败对象。
        //return R2.FAIL(CodeEnum.CREATION_FAILED);

        //修改失败，则返回一个R2修改失败对象。
        return R2.FAIL(CodeEnum.MODIFICATION_FAILED);
    }
    //{
    //	"code": 200,
    //	"msg": "成功",
    //	"data": {
    //		"userId": "1002",
    //		"userName": "Lucy"
    //	}
    //}

    //{
    //	"code": 400,
    //	"msg": "失败",
    //	"data": null
    //}

    //{
    //	"code": 400,
    //	"msg": "创建失败",
    //	"data": null
    //}

    //{
    //	"code": 400,
    //	"msg": "修改失败",
    //	"data": null
    //}
}
