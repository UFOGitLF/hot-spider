package com.hacker.service;

import com.hacker.entity.CategoryType;

import java.util.List;

public interface CategoryTypeService {

    void save(CategoryType categoryType);
    
    List<CategoryType> findAll();
}
