package com.wyjun;

import com.wyjun.service.AsyncService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MySpringBootApplicationTests {

    @Resource
    private AsyncService asyncService;

    @Test
    void contextLoads() {
    }

    @Test
    void testAsyn() {
        // 将任务提交给线程池去处理，这是一个异步方法。
        asyncService.doTask();//这一步会立即结束，不会阻塞当前线程。
        System.out.println("testAsyn end....");
    }
    //testAsyn end....
    //async-task-1开始处理任务：2026-10-26T23:40:30.261341300
    //async-task-1处理任务完成：2026-10-26T23:40:40.262214500
}
