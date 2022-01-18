package com.example.quartz.config;


import com.example.quartz.job.PrintWordsJob;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author 权计超
 * Company DXC.technology
 * @CreateTime 2022-01-18 15:31
 * @Description: Quartz配置类
 */
@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail printTimeJobDetail(){
        return JobBuilder.newJob(PrintWordsJob.class)//PrintTimeJob我们的业务类
                .withIdentity("PrintTimeJob")//可以给该JobDetail起一个id
                //每个JobDetail内都有一个Map，包含了关联到这个Job的数据，在Job类中可以通过context获取
                .usingJobData("msg", "Hello Quartz")//关联键值对
                .storeDurably()//即使没有Trigger关联时，也不需要删除该JobDetail
                .build();
    }
    @Bean
    public Trigger printTimeJobTrigger() {
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder
                //cron表达式
                .cronSchedule("0/10 0/1 * * * ? *");
        return TriggerBuilder.newTrigger()
                .forJob("PrintTimeJob")//关联任务名
                .withIdentity("quartzTaskService")//Trigger触发器名称
                .withSchedule(cronScheduleBuilder)
                .build();
    }
}
