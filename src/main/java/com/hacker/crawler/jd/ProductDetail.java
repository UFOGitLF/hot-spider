package com.hacker.crawler.jd;

import com.geccocrawler.gecco.annotation.Attr;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Image;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;

public class ProductDetail implements HtmlBean {

	private static final long serialVersionUID = -6362237918542798717L;

	@Attr(value = "data-sku")
	@HtmlField(cssPath = "div.j-sku-item")
	private String pCode;

	@Image({ "data-lazy-img", "src" })
	@HtmlField(cssPath = "div.j-sku-item > div.p-img > a > img")
	private String pImg;

	
	//#plist > ul > li:nth-child(1) > div > div.p-price > strong:nth-child(1) > i
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

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public String getpImg() {
		return pImg;
	}

	public void setpImg(String pImg) {
		this.pImg = pImg;
	}

	public String getpPrice() {
		return pPrice;
	}

	public void setpPrice(String pPrice) {
		this.pPrice = pPrice;
	}

	public String getpTitle() {
		return pTitle;
	}

	public void setpTitle(String pTitle) {
		this.pTitle = pTitle;
	}

	public String getpComment() {
		return pComment;
	}

	public void setpComment(String pComment) {
		this.pComment = pComment;
	}

	public String getpShop() {
		return pShop;
	}

	public void setpShop(String pShop) {
		this.pShop = pShop;
	}

	public List<String> getpIcons() {
		return pIcons;
	}

	public void setpIcons(List<String> pIcons) {
		this.pIcons = pIcons;
	}

}
