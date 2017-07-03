package com.hacker.crawler.jd;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;

/**
 * 京东所有商品的页面抓取
 * @Title AllSort.java
 * @Description
 * @author Succy
 * @date 2016年11月16日 下午9:32:09
 * @version 1.0
 * @Company www.succy.cn
 */
@Gecco(matchUrl = "https://www.jd.com/allSort.aspx", pipelines = { "allSortPipeline",
		"consolePipeline" })
public class AllSort implements HtmlBean {

	private static final long serialVersionUID = 3422937382621558860L;

	@Request
	private HttpRequest request;

	/**
	 * 抓取手机模块的数据
	 */
	@HtmlField(cssPath = "div.category-items > div:nth-child(1) > div:nth-child(2) > div.mc > div.items > dl")
	private List<Category> cellPhone;

	public HttpRequest getRequest() {
		return request;
	}

	public void setRequest(HttpRequest request) {
		this.request = request;
	}

	public List<Category> getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(List<Category> cellPhone) {
		this.cellPhone = cellPhone;
	}
}
