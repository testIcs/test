package com.zxkj.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.zxkj.dao.DicMapper;
import com.zxkj.service.IDic;

@Scope("prototype")
@Service("dicService")
public class DicServiceImpl implements IDic 
{
	
	private static final Logger LOG = LoggerFactory.getLogger(DicServiceImpl.class);
	
	@Autowired(required = true)
	private DicMapper dicMapper;
	
	/**
	 * 查询金融产品字典信息 
	 */
	@Override
	public List<Map<Integer, String>> findFinancialProducts() {
		return dicMapper.findFinancialProducts();
	}
	
	/**
	 * 查询贷款利率字典信息 
	 */
	@Override
	public List<Map<Integer, String>> findLendingRate() {
		return dicMapper.findLendingRate();
	}
	
	/**
	 * 查询贷款期限字典信息  
	 */
	@Override
	public List<Map<Integer, String>> findLoanTerm() {
		return dicMapper.findLoanTerm();
	}
}
