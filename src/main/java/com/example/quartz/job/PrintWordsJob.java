package com.example.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @Author 权计超
 * Company DXC.technology
 * @CreateTime 2022-01-18 15:14
 * @Description: 打印job
 */
public class PrintWordsJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String printTime = new SimpleDateFormat("yy-MM-dd HH-mm-ss").format(new Date());
        System.out.println("打印Job 开始于:" + printTime + ", 打印内容: Hello Job-" + new Random().nextInt(100));
    }
}
