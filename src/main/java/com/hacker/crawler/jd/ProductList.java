package com.hacker.crawler.jd;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;

/**
 * 商品列表实体类，对应的是京东的类目连接到的页面的每页60条记录
 * @Title ProductList.java
 * @Description
 * @author Succy
 * @date 2016年11月19日 下午1:58:37
 * @version 1.0
 * @Company www.succy.cn
 */
@Gecco(matchUrl = "https://list.jd.com/list.html?cat={cat}", pipelines = { "consolePipeline",
		"filePipeline" ,"mongoPipeline"})
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

	 public HttpRequest getRequest() {
	 return request;
	 }
	
	 public void setRequest(HttpRequest request) {
	 this.request = request;
	 }

	public List<ProductDetail> getDetails() {
		return details;
	}

	public void setDetails(List<ProductDetail> details) {
		this.details = details;
	}

}
