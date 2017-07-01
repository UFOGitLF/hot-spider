package com.hacker.crawler.jd;

import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HrefBean;
import com.geccocrawler.gecco.spider.HtmlBean;
import lombok.Data;

import javax.persistence.Entity;
import java.util.List;

@Data
public class Category implements HtmlBean {

    private static final long serialVersionUID = -1808704248579938878L;

    /**
     * 对应的是大的分类名字，如手机通讯，运营商，手机配件等
     */
    @Text
    @HtmlField(cssPath = "dt > a")
    private String typeName;

    /**
     * 相对于上面的大的分类下的小类目名字
     */
    @HtmlField(cssPath = "dd > a")
    private List<HrefBean> categories;
}