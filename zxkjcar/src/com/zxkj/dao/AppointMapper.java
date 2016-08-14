package com.zxkj.dao;

import java.util.List;
import java.util.Map;

import org.apache.poi.poifs.storage.ListManagedBlock;

import com.zxkj.model.Appointment;
import com.zxkj.model.User;


public interface AppointMapper {
	/**
	 * 用户登录
	 * @param user 登陆的用户信息
	 * @return 返回登陆状态
	 */
	User login(String userName);
	
	/**
	 * 判断账号是否存在
	 * @param userName
	 * @return
	 */
	Integer judgeAccount(String userName);
	
	/**
	 * 用户注册
	 * @param user
	 */
	Integer addUser(User user);
	
	/**
	 * 预约事件添加
	 * @param appointment
	 */
	Integer addAppointment(Appointment appointment);
	
	/**
	 * 预约大厅数据查询
	 * @return
	 */
	List<Map<String, Object>> listBookingHall(Map<String, String> paramsMap);
	
	/**
	 * 预约数据明细
	 * @return
	 */
	List<Map<String, Object>> listAppointDetail(Map<String, String> paramsMap);
	
	List<User> findUsersBySlot(Map<String, Object> map);
}
