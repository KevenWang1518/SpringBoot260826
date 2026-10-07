package com.wyjun;

import com.wyjun.entity.Vip;
import com.wyjun.service.VipService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MySpringBootApplicationTests {

    @Autowired
    private VipService vipService;

    @Test
    void contextLoads() {

        // 查询所有会员信息并逐个打印
        //vipService.getAllVips().forEach(System.out::println);

        // 查询所有会员信息
        System.out.println(vipService.getAllVips());

        // 根据id查询单个会员信息
        System.out.println(vipService.selectVipById(1L));

        // 根据id删除单个会员信息
        System.out.println(vipService.deleteVipById(4L));

        // 添加会员信息
        Vip newVip = new Vip(null, "John", "1234567892", "1999-11-10");
        vipService.insertVip(newVip);

        // 更新会员信息
        Vip modifyVip = new Vip(6L, "Lucy", "1234567899", "2001-11-10");
        vipService.updateVip(modifyVip);
    }

}
