package com.zxkj.dao;

import java.util.List;

import com.zxkj.model.User;

public interface UserMapper
{
    /**
     * 用户登录
     * 
     * @param user
     *            登陆的用户信息
     * @return 返回登陆状态
     */
    public User login(String phoneNo);

    /**
     * 判断账号是否存在
     * 
     * @param userName
     * @return
     */
    public Integer judgeAccount(String userName);

    /**
     * 用户注册
     * 
     * @param user
     */
    public Integer addUser(User user);

    void updateUser(User user);

    /**
     * 查询需要审核的人员
     * 
     * @return
     */
    List<User> queryBeAuditedUser();

    /**
     * 查询已审核的人员
     * 
     * @return
     */
    List<User> queryAuditedUser();

    /**
     * 删除用户
     * 
     * @param id
     */
    void deleteUser(Integer id);

    /**
     * 手机号是否存在
     * 
     * @param phone
     * @return
     * @throws BusinessException
     */
    Integer phoneExist(String phone);

    /**
     * 根据用户id查询用户
     * 
     * @param userId
     * @return
     */
    User queryUserById(Integer userId);
}
