package com.hacker.crawler.jd;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;
import lombok.Data;

import java.util.List;

@Gecco(matchUrl = "https://www.jd.com/allSort.aspx", pipelines = {"allSortPipeline",
        "consolePipeline"})
@Data
public class AllSort implements HtmlBean {

    private static final long serialVersionUID = 3422937382621558860L;

    @Request
    private HttpRequest request;

    /**
     * 抓取手机模块的数据
     */
    @HtmlField(cssPath = "div.category-items > div:nth-child(1) > div:nth-child(2) > div.mc > div.items > dl")
    private List<Category> cellPhone;
}
