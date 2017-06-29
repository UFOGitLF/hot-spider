package com.hacker.service.impl;

import com.hacker.entity.PictureInfo;
import com.hacker.mapper.PictureInfoMapper;
import com.hacker.service.PictureInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 详情
 */
@Service
public class PictureInfoServiceImpl implements PictureInfoService {

	@Autowired
	private PictureInfoMapper pictureInfoMapper;

	@Override
	public int save(PictureInfo pictureInfo) {

		return pictureInfoMapper.insert(pictureInfo);
	}

}
