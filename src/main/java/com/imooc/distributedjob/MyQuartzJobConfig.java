package com.imooc.distributedjob;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyQuartzJobConfig {

    @Bean
    public JobDetail jobDetail() {
        JobDetail detail = JobBuilder.newJob(MyQuartzJob.class)
                .withIdentity("job1", "group1")
                .storeDurably()
                .build();
        return detail;
    }

    @Bean
    public Trigger trigger() {
        Trigger trigger = TriggerBuilder.newTrigger()
                .forJob(jobDetail())
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ?"))
                .build();
        return trigger;
    }
}
