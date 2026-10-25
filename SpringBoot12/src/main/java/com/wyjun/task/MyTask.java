package com.wyjun.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

// 定时任务类纳入IoC容器的管理。
@Component
public class MyTask {

    // 指定定时任务：每隔5秒执行一次任务，以固定周期方式执行。
    @Scheduled(fixedRate = 3000)
    // 这里写具体的任务代码。
    // 数据备份?发送邮件?
    public void doTask() {
        System.out.println(LocalDateTime.now());
    }
}
