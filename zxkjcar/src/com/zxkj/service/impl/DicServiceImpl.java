package com.zxkj.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.zxkj.common.Constants;
import com.zxkj.dao.UserMapper;
import com.zxkj.model.User;
import com.zxkj.service.DicService;
import com.zxkj.service.UserService;

@Scope("prototype")
@Service("dicService")
public class DicServiceImpl implements DicService 
{
	
	private static final Logger LOG = LoggerFactory.getLogger(DicServiceImpl.class);
	
	@Autowired(required = true)
//	private DicMapper dicMapper;
	
	/**
	 * 查询金融产品字典信息 
	 */
	@Override
	public List<Map<Integer, String>> findFinancialProducts()
	{
//		return dicMapper.findFinancialProducts();
		return null;
	}
	
	/**
	 * 查询贷款利率字典信息 
	 */
	@Override
	public List<Map<Integer, String>> findLendingRate() 
	{
//		return dicMapper.findLendingRate();
		return null;
	}
	
	/**
	 * 查询贷款期限字典信息  
	 */
	@Override
	public List<Map<Integer, String>> findLoanTerm() 
	{
//		return dicMapper.findLoanTerm();
		return null;
	}

	@Override
	public List<Map<String, Object>> findTimeSlots() 
	{
		return null;
	}
}
