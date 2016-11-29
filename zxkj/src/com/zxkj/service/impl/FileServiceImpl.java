package com.zxkj.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.zxkj.dao.FileMapper;
import com.zxkj.model.FileInfo;
import com.zxkj.service.IFile;

@Scope("prototype")
@Service("fileService")
public class FileServiceImpl implements IFile
{
	private static final Logger LOG = LoggerFactory.getLogger(FileServiceImpl.class);

	@Resource
	private FileMapper fileMapper;
	
	@Override
	public Integer saveFileInfo(FileInfo fileInfo) 
	{
		fileMapper.saveFileInfo(fileInfo);
		return fileInfo.getId();
	}
}
