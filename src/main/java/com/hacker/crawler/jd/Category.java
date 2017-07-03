package com.hacker.crawler.jd;

import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HrefBean;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;

/**
 * 对应京东分类页面的每条类目的HtmlBean
 * @Title Category.java
 * @Description
 * @author Succy
 * @date 2016年11月19日 下午3:05:57
 * @version 1.0
 * @Company www.succy.cn
 */
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

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public List<HrefBean> getCategories() {
		return categories;
	}

	public void setCategories(List<HrefBean> categories) {
		this.categories = categories;
	}
}
