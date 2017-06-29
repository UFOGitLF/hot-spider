package com.hacker.job;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.spring.SpringPipelineFactory;
import com.hacker.entity.ScheduleJob;
import com.hacker.utils.SpringContextUtil;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 任务：妹子图
 */
@DisallowConcurrentExecution
public class MeizituJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        ScheduleJob scheduleJob = (ScheduleJob) context.getMergedJobDataMap().get("scheduleJob");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        System.out.println("任务名称 = [" + scheduleJob.getName() + "]" + " 在 " + dateFormat.format(new Date()) + " 时运行");

        SpringPipelineFactory springPipelineFactory = SpringContextUtil.getBean("springPipelineFactory");

        HttpGetRequest start = new HttpGetRequest("http://www.meizitu.com/");
        start.setCharset("GBK");
        GeccoEngine.create()
                .pipelineFactory(springPipelineFactory)
                .classpath("com.hacker.crawler")
                .start(start)
                .loop(false)
                .run();
    }
}