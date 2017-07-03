package com.hacker.crawler.jd;

import com.alibaba.fastjson.JSON;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.spider.SpiderBean;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@PipelineName("filePipeline")
public class FilePipeline implements Pipeline<SpiderBean> {

    @Override
    public void process(SpiderBean bean) {
        try {

            PrintWriter pw = new PrintWriter(new FileWriter("data.txt", true));
            // pw.println(JSON.toJSONString(bean));
            pw.println(JSON.toJSONString(bean));
            pw.flush();
            pw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
