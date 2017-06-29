package com.hacker.service.impl;

import com.hacker.entity.Picture;
import com.hacker.mapper.PictureMapper;
import com.hacker.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PictureServiceImpl implements PictureService {

	@Autowired
	private PictureMapper pictureMapper;

	@Override
	public int save(Picture picture) {
		return pictureMapper.insert(picture);
	}

}
