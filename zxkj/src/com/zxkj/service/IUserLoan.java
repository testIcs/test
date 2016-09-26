/**
 * 
 */
package com.zxkj.service;

import com.zxkj.vo.UserLoanVO;

/**
 * 字典信息操作SERVICE
 */
public interface IUserLoan
{
    Integer saveUserLoanInfo(UserLoanVO userLoanVO);

    /**
     * 贷款试算收集手机号 判断手机号是否已经存在
     * 
     * @param phoneNo
     * @return
     */
    boolean judgePhoneExist(String phoneNo);

    /**
     * 贷款试算收集手机号
     * 
     * @param phoneNo
     */
    void addPhone(String phoneNo);

}
