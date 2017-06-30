package com.hacker.job;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spring.SpringPipelineFactory;
import com.hacker.crawler.jd.AllSortPipeline;
import com.hacker.entity.ScheduleJob;
import com.hacker.utils.SpringContextUtil;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 定时任务:爬取京东
 */
@DisallowConcurrentExecution
public class JdSpiderJob implements Job {
    private static final String JD_URL = "https://www.jd.com/allSort.aspx";

    public void execute(JobExecutionContext context) throws JobExecutionException {
        ScheduleJob scheduleJob = (ScheduleJob) context.getMergedJobDataMap().get("scheduleJob");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");

        System.out.println("任务名称 = [" + scheduleJob.getName() + "]" + " 在 " + dateFormat.format(new Date()) + " 时运行");

        SpringPipelineFactory springPipelineFactory = SpringContextUtil.getBean("springPipelineFactory");

        String classpath = "com.hacker.crawler.jd";
        HttpRequest request = new HttpGetRequest(JD_URL);
        request.setCharset("gb2312");
        // 如果pipeline和htmlbean不在同一个包，classpath就要设置到他们的共同父包
        // 本引擎主要是把京东分类的页面手机板块给抓取过来封装成htmlbean
        GeccoEngine.create().classpath(classpath).start(request).interval(2000).run();

        // 本引擎是负责抓取每一个细目对应的页面的第一页的所有商品列表的数据，开启5个线程同时抓取，提升效率
        GeccoEngine.create().classpath(classpath).start(AllSortPipeline.cateRequests).thread(5)
                .interval(2000).run();
    }
}
