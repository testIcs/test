package com.zxkj.service;

import com.zxkj.vo.UserFingerPrintVO;

public interface IUserFingerPrint 
{
	UserFingerPrintVO findUFPByUserId(Integer userId);
	
	void saveUFPVO(UserFingerPrintVO ufpVO);
}
