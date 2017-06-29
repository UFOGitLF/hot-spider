package com.hacker.crawler;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Image;
import com.geccocrawler.gecco.annotation.RequestParameter;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;

/**
 * 大图
 * Created by Lenovo on 2017/6/29.
 */
@Gecco(matchUrl = "http://www.meizitu.com/a/{code}.html",pipelines = {"consolePipeline","bigPicPipeline"})
public class BigPic implements HtmlBean{
    private static final Long serialVersionUID = 1L;

    @RequestParameter
    private int picInfoId;

    @Image
    @HtmlField(cssPath = ".postContent img")
    private List<String> pics;

    public List<String> getPics() {
        return pics;
    }

    public void setPics(List<String> pics) {
        this.pics = pics;
    }

    public int getPicInfoId() {
        return picInfoId;
    }

    public void setPicInfoId(int picInfoId) {
        this.picInfoId = picInfoId;
    }

    public static void main(String[] args) {
        HttpGetRequest start = new HttpGetRequest("http://www.meizitu.com/a/375.html");
        start.setCharset("GBK");
        GeccoEngine.create().classpath("com.hacker.crawler").start(start).interval(2000).loop(false).run();
    }
}
