package com.hacker.crawler.jd;

import com.geccocrawler.gecco.annotation.Attr;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Image;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HtmlBean;
import lombok.Data;

import java.util.List;

@Data
public class ProductDetail implements HtmlBean {

    private static final long serialVersionUID = -6362237918542798717L;

    @Attr(value = "data-sku")
    @HtmlField(cssPath = "div.j-sku-item")
    private String pCode;

    @Image({ "data-lazy-img", "src" })
    @HtmlField(cssPath = "div.j-sku-item > div.p-img > a > img")
    private String pImg;

    @Text
    @HtmlField(cssPath = "div.j-sku-item > div.p-price > strong:nth-child(1) > i")
    private String pPrice;

    @Text
    @HtmlField(cssPath = "div.j-sku-item > div.p-name > a > em")
    private String pTitle;

    @Text
    @HtmlField(cssPath = "div.j-sku-item > div.p-comment > strong > a.comment")
    private String pComment;

    @Text
    @HtmlField(cssPath = "div.j-sku-item > div.p-shop > span > a")
    private String pShop;

    @Text
    @HtmlField(cssPath = "div.j-sku-item > div.p-icons > *")
    private List<String> pIcons;

}