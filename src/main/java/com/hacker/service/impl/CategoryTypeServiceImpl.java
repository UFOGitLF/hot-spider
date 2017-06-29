package com.hacker.service.impl;

import com.hacker.entity.CategoryType;
import com.hacker.mapper.CategoryTypeMapper;
import com.hacker.service.CategoryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryTypeServiceImpl implements CategoryTypeService {

    @Autowired
    private CategoryTypeMapper categoryTypeMapper;

    @Override
    public void save(CategoryType categoryType) {
        categoryTypeMapper.insert(categoryType);
    }

	@Override
	public List<CategoryType> findAll() {
		return categoryTypeMapper.findAll();
	}
}
