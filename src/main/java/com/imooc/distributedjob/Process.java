package com.imooc.distributedjob;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Process {
    // 慎用，@Async 多线程的
    @Async
    public void doProcess1() throws InterruptedException {
        Thread.sleep(5000);

        String a  = "a";


    }
}
