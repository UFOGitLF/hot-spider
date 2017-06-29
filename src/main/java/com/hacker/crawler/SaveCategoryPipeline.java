package com.hacker.crawler;

import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.SchedulerContext;
import com.hacker.entity.CategoryType;
import com.hacker.service.CategoryTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SaveCategoryPipeline implements Pipeline<IndexPage> {

	@Resource(name="categoryTypeServiceImpl")
	private CategoryTypeService categoryTypeService;

	@Override
	public void process(IndexPage bean) {
		List<CategoryType> categoryTypes = bean.getCategoryTypes();
		for (CategoryType categoryType : categoryTypes) {
			categoryTypeService.save(categoryType);
			HttpRequest sub = bean.getRequest().subRequest(categoryType.getUrl());
			sub.addParameter("tag", ""+categoryType.getId());
			SchedulerContext.into(sub);
		}
	}
}
