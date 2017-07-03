package com.hacker.crawler.jia;

import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HtmlBean;
import lombok.Data;

import java.util.List;

/**
 * 房子信息
 * Created by Lenovo on 2017/7/3.
 */
@Data
public class Hourse implements HtmlBean {
    @Text
    @HtmlField(cssPath = "div > h2 > a")
    //标题
    private String title;

    @Text
    @HtmlField(cssPath = "div > ul > li:nth-child(1) > a:nth-child(1) > h3")
    //小区
    private String quarters;

    @Text
    @HtmlField(cssPath = "div > ul > li:nth-child(1) > a:nth-child(2)")
    //地区
    private String region;

    @Text
    @HtmlField(cssPath = "div > ul > li:nth-child(1) > a:nth-child(3)")
    //主题
    private String topic;

    @Text
    @HtmlField(cssPath = "div > ul > li.font-balck > span")
    //描述
    private List<String> desc;

    @Text
    @HtmlField(cssPath = "div > div > h3")
    //总价
    private String totalPrice;

    @Text
    @HtmlField(cssPath = "div > div > h3 > em")
    //单位
    private String unit;

    @Text
    @HtmlField(cssPath = "div > div > p")
    //每平米单价
    private String perPrice;


}
