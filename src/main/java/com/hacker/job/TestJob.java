package com.hacker.job;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.request.HttpRequest;
import com.hacker.crawler.jd.AllSortPipeline;

/**
 * Created by Lenovo on 2017/7/3.
 */
public class TestJob {

    public static void main(String[] args) {
        String classpath = "com.hacker.crawler.jia";
        HttpRequest request = new HttpGetRequest("http://bj.5i5j.com/exchange");
        request.setCharset("utf-8");
        GeccoEngine.create().classpath(classpath).start(request).interval(2000).run();

        GeccoEngine.create().classpath(classpath).start(AllSortPipeline.cateRequests).thread(5)
                .interval(2000).run();
    }
}
