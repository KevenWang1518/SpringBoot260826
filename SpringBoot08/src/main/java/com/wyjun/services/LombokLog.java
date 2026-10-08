package com.wyjun.services;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
public class LombokLog {

    // 使用 @Slf4j 底层会自动生成这样一个log常量，使用它来记录日志。（常量在字节码中看不到）
    //private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LombokLog.class);

    public static void transfer(String from, String to, BigDecimal amount) {
        log.info("from:{}, to:{}, amount:{}", from, to, amount);
    }

    public static void main(String[] args) {
        transfer("act-001", "act-002", new BigDecimal(100));
    }
}
