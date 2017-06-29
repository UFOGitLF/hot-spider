package com.hacker.mapper;


import com.hacker.entity.PictureInfo;

public interface PictureInfoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(PictureInfo record);

    int insertSelective(PictureInfo record);

    PictureInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PictureInfo record);

    int updateByPrimaryKey(PictureInfo record);
}