package com.wyjun.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component //把这个类交给Spring容器管理，变成Spring Bean，Spring才能识别这个切面。
@Aspect //标记这是一个切面类，AOP的核心注解，代表这个类里面写的是切面增强逻辑。
public class LogAspect {

    //拦截这个包下面所有类的所有方法
    //@Before("execution(* com.wyjun.service.impl.*.*(..))")

    @Before("execution(* com.wyjun.service.impl.VipServiceImpl.save())")//前置通知：目标方法执行之前，先执行这个方法。
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("before advice execute ...");
    }
}
