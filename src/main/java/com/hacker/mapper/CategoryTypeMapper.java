package com.hacker.mapper;


import com.hacker.entity.CategoryType;

import java.util.List;


public interface CategoryTypeMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(CategoryType record);

    int insertSelective(CategoryType record);

    CategoryType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CategoryType record);

    int updateByPrimaryKey(CategoryType record);

	List<CategoryType> findAll();
}