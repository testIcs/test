package com.zxkj.dao;

import com.zxkj.vo.UserLoanVO;

public interface UserLoanMapper
{

    Integer saveUserLoanInfo(UserLoanVO userLoanVO);

    /**
     * 贷款试算收集手机号 判断手机号是否已经存在
     * 
     * @param phoneNo
     * @return
     */
    Integer judgePhoneExist(String phoneNo);

    /**
     * 贷款试算收集手机号
     * 
     * @param phoneNo
     */
    void addPhone(String phoneNo);
}
