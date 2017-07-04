package com.hacker.crawler.jd;

import com.alibaba.fastjson.JSON;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HrefBean;
import com.hacker.utils.MongoDBUtil;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

@PipelineName("allSortPipeline")
public class AllSortPipeline implements Pipeline<AllSort> {

	public static List<HttpRequest> cateRequests = new ArrayList<>();

<<<<<<< HEAD
	@Override
	public void process(AllSort allSort) {
		List<Category> cellPhones = allSort.getCellPhone();
		for (Category category : cellPhones) {
			// 获取mongo的集合
			MongoCollection<Document> collection = MongoDBUtil.instance.getCollection("test","jd_spider");
			// 把json转成Document
			Document doc = Document.parse(JSON.toJSONString(category));
			// 向集合里边插入一条文档
			collection.insertOne(doc);
			List<HrefBean> hrefs = category.getCategories();
			// 遍历HrefBean，取出里边保存的url
			for (HrefBean href : hrefs) {
				HttpRequest request = allSort.getRequest();
				// 把url保存起来，方便后面开启一个新的引擎进行多线程抓取数据
				cateRequests.add(request.subRequest(href.getUrl()));
			}
		}
	}
=======
    @Override
    public void process(AllSort allSort) {
        List<Category> cellPhones = allSort.getCellPhone();
        for (Category category : cellPhones) {
            // 获取mongo的集合
            MongoCollection<Document> collection = MongoDBUtil.instance.getCollection("test", "jd_spider");
            // 把json转成Document
            Document doc = Document.parse(JSON.toJSONString(category));
            // 向集合里边插入一条文档
            collection.insertOne(doc);
            List<HrefBean> hrefs = category.getCategories();
            // 遍历HrefBean，取出里边保存的url
            for (HrefBean href : hrefs) {
                HttpRequest request = allSort.getRequest();
                // 把url保存起来，方便后面开启一个新的引擎进行多线程抓取数据
                cateRequests.add(request.subRequest(href.getUrl()));
            }
        }
    }
>>>>>>> dev
}
