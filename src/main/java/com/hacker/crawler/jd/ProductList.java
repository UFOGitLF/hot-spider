package com.hacker.crawler.jd;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;
import lombok.Data;

import java.util.List;

@Data
@Gecco(matchUrl = "https://list.jd.com/list.html?cat={cat}", pipelines = { "consolePipeline", "filePipeline" ,"mongoPipeline"})
public class ProductList implements HtmlBean {

    private static final long serialVersionUID = -6580138290566056728L;

    /**
     * 获取请求对象，从该对象中可以获取抓取的是哪个url
     */
     @Request
     private HttpRequest request;

    // #plist > ul > li.gl-item > div.j-sku-item
    @HtmlField(cssPath = "#plist > ul > li.gl-item")
    private List<ProductDetail> details;

}