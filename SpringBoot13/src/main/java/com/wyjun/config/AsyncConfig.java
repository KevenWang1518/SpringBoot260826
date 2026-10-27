package com.wyjun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class AsyncConfig {

    /**
     * 默认线程池 - 用于通用异步任务
     */
    @Bean("taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        // 核心线程数：线程池创建时初始化的线程数
        executor.setCorePoolSize(10);
        // 最大线程数：线程池最大的线程数，只有在缓冲队列满了之后才会申请超过核心线程数的线程
        executor.setMaxPoolSize(20);
        // 缓冲队列：用来缓冲执行任务的队列
        executor.setQueueCapacity(200);
        // 允许线程的空闲时间：当超过了核心线程之外的线程在空闲时间到达之后会被销毁
        executor.setKeepAliveSeconds(60);
        // 线程池名的前缀：设置好了之后可以方便我们定位处理任务所在的线程池
        executor.setThreadNamePrefix("async-task-");

        // 线程池对拒绝任务的处理策略
        // 当线程池"满了"（队列也满了）的时候，新来的任务怎么处理?
        // CallerRunsPolicy 表示“调用者运行”策略，让提交任务的线程（比如Tomcat的HTTP线程）自己去执行这个任务
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        // 等待所有任务结束后再关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        // 等待时间：如果60秒了任务还没有完成，也会关闭线程池，避免一直等。等待时间可调整。
        executor.setAwaitTerminationSeconds(60);

        // 初始化线程池
        executor.initialize();
        return executor;
    }

    /**
     * 专用线程池 - 用于IO密集型任务
     */
    @Bean("ioTaskExecutor")
    public Executor iOTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        int cpuCores = Runtime.getRuntime().availableProcessors();
        // IO密集型任务大部分时间CPU都在等待，多开线程可以让CPU在等待期间处理其他任务，提高总体利用率。
        // IO密集型任务最大线程数量一般配置为CPU核心数的2倍或4倍。
        executor.setCorePoolSize(cpuCores * 2);
        executor.setMaxPoolSize(cpuCores * 4);
        executor.setQueueCapacity(500);
        executor.setKeepAliveSeconds(30);
        executor.setThreadNamePrefix("async-io-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }

    /**
     * 专用线程池 - 用于CPU密集型任务
     */
    @Bean("cpuTaskExecutor")
    public Executor cpuTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // CPU密集型线程数不宜过多，通常为CPU核数+1
        // 加1是为了应对线程在执行过程中因为缺页中断、GC停顿或其他系统原因被暂停时，
        // CPU能立刻有一个备用线程顶上，确保CPU始终满负荷运转，不让处理能力“空转”。
        int cpuCores = Runtime.getRuntime().availableProcessors();
        executor.setCorePoolSize(cpuCores + 1);
        // CPU密集型最大线程数量一般是CPU核心数+1
        executor.setMaxPoolSize(cpuCores + 1);
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("async-cpu-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        executor.initialize();
        return executor;
    }
}