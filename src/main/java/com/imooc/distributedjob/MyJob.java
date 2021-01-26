package com.imooc.distributedjob;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MyJob {

    @Autowired
    private Process process;


    // initialDelay 延迟启动
    // fixedDelay 固定延迟，时间间隔是前次任务的结束到下次任务的开始
    // fixedRate 固定频率，时间间隔是前次任务和下次任务的开始
//    @Scheduled(cron = "* * * * * ?")
//    public void process() throws InterruptedException {
//        log.info("process....start");
//        Thread.sleep(2000);
//        log.info("process....stop");
//    }


    @Scheduled(fixedRate = 3000)
    public void process1() throws InterruptedException {
        log.info("process1....start");
        process.doProcess1();
        log.info("process1....stop");

    }

//    @Scheduled(fixedRate = 3000)
//    public void process2() {
//        log.info("process2....");
//    }

    @Async
    public void doProcess1() throws InterruptedException {
        Thread.sleep(5000);
    }
}
