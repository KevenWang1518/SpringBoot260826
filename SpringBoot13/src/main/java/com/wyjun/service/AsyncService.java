package com.wyjun.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Service
public class AsyncService {

    // 指定异步方法，并且指定使用哪个线程池。
    @Async("taskExecutor")
    public void doTask() { //异步方法，不会阻塞主线程。
        System.out.println(Thread.currentThread().getName() + "开始处理任务：" + LocalDateTime.now());
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + "处理任务完成：" + LocalDateTime.now());
    }

    public void doSome() {
        //注意:这里doSome直接通过当前对象this调用doTask方法，是不走异步方法的。因为异步方法的实现是基于代理机制的。
        this.doTask();
    }
}