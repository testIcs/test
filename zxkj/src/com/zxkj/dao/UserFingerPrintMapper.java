package com.zxkj.dao;


import com.zxkj.vo.UserFingerPrintVO;

public interface UserFingerPrintMapper 
{
	UserFingerPrintVO findUFPByUserId(Integer userId);
	
	void saveUFPVO(UserFingerPrintVO ufpVO);
}
