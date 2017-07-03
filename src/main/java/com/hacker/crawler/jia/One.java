package com.hacker.crawler.jia;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.spider.HtmlBean;
import lombok.Data;

import java.util.List;

/**
 * 抓取起始页
 * Created by Lenovo on 2017/7/3.
 */
@Gecco(matchUrl = "http://bj.5i5j.com/exchange",pipelines = {"consolePipeline"})
@Data
public class One implements HtmlBean{

    @HtmlField(cssPath = "#exchangeList > div > ul > li")
    private List<Hourse> hourseList;

}
