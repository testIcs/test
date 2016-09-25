package com.zxkj.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.zxkj.dao.UserFingerPrintMapper;
import com.zxkj.service.IUserFingerPrint;
import com.zxkj.vo.UserFingerPrintVO;

/**
 * {@inheritDoc}
 * @author
 */
@Scope("prototype")
@Service("ufpService")
public class UserFingerPrintServiceImpl implements IUserFingerPrint
{
	private static final Logger LOG = LoggerFactory.getLogger(UserFingerPrintServiceImpl.class);

	@Resource
	private UserFingerPrintMapper ufpMapper;
	
	@Override
	public UserFingerPrintVO findUFPByUserId(Integer userId) 
	{
		return ufpMapper.findUFPByUserId(userId);
	}

	@Override
	public void saveUFPVO(UserFingerPrintVO ufpVO) 
	{
		ufpMapper.saveUFPVO(ufpVO);
	}
}
