package com.zxkj.service.impl;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.zxkj.dao.UserLoanMapper;
import com.zxkj.service.IUserLoan;
import com.zxkj.vo.UserLoanVO;

/**
 * {@inheritDoc}
 * @author
 */
@Scope("prototype")
@Service("userLoanService")
public class UserLoanServiceImpl implements IUserLoan 
{
	private static final Logger LOG = LoggerFactory.getLogger(UserLoanServiceImpl.class);
	
	@Autowired(required = true)
	private UserLoanMapper userLoanMapper;

	@Override
	public Integer saveUserLoanInfo(UserLoanVO userLoanVO) 
	{
		return userLoanMapper.saveUserLoanInfo(userLoanVO);
	}

	
}
