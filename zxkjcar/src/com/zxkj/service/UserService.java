/**
 * 
 */
package com.zxkj.service;

import java.util.List;
import java.util.Map;

import com.zxkj.model.User;

/**
 * 用户操作SERVICE
 */
public interface UserService
{
    /**
     * 用户登录
     * 
     * @param user
     *            登陆的用户信息
     * @return 返回登陆状态 0 成功，1用户名或密码错误，-1其它错误
     */
    public Map<String, Object> login(User user);

    /**
     * 判断账号是否存在
     * 
     * @param user
     * @return
     */
    public boolean judgeAccount(User user);

    /**
     * 用户注册
     * 
     * @param user
     */
    public Integer addUser(User user);

    /**
     * 编辑用户
     * 
     * @param user
     */
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
    Boolean phoneExist(String phone);

    /**
     * 根据用户id查询用户
     * 
     * @param userId
     * @return
     */
    User queryUserById(Integer userId);
}
