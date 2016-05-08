package com.zxkj.common;

/**
 * 错误码常量
 * @author mengqingfeng
 */
public class Constants {
	/**
	 * 未授权
	 */
	public static final int UNGRANT = -2000;
	/**
	 * 服务器异常
	 */
	public static final int SERVER_ERROR = -1000;
	/**
	 * 状态OK
	 */
	public static final int STATUS_OK = 0;
	/**
	 * 状态错误
	 */
	public static final int STATUS_ERROR = 1000;
	/**
	 * 数据不正确
	 */
	public static final int DATA_INCORRECT = 2000;
	/**
	 * 数据已存在
	 */
	public static final int DATA_ALREADY_EXIST = 3000;
	/**
	 * 数据未找到
	 */
	public static final int DATA_NOT_FOUND = 4000;
	/**
	 * 数据不完整
	 */
	public static final int DATA_NOT_COMPLETE = 5000;
	/**
	 * 验证码不正确
	 */
	public static final int VALIDATE_NOT_COMPLETE = 6000;
	/**
	 * 数据已过期
	 */
	public static final int VALIDATE_EXPIRES = 7000;
	
	/**
	 * 审核通过
	 */
	public static final String AUDIT_PASS = "PASS";
	
	/**
	 * 审核驳回
	 */
	public static final String AUDIT_NOPASS = "NO_PASS";
	
	/**
	 * 申请中
	 */
	public static final int NUM_ZERO_AUDIT = 0;
	
	/**
	 * 申请通过
	 */
	public static final int NUM_ONE_AUDIT = 1;
	
	/**
	 * 申请未通过
	 */
	public static final int NUM_TWO_AUDIT = 2;
	
	/**
	 * 审核驳回
	 */
	public static final int NUM_THREE_PASS = 3;
	
	/**
	 * 提现申请审核轨迹表中审核驳回
	 */
	public static final int NUM_FOUR_PASS = 4;
	
	/**
	 * 项目
	 */
	public static final int PROJECT_TYPE = 1;
	
	/**
	 * 红包
	 */
	public static final int REDBAG_TYPE = 2;
	
	/**
	 * 摇大奖
	 */
	public static final int YDJ_TYPE = 3;
	
	/**
	 * 砸蛋
	 */
	public static final int ZD_TYPE = 4;
	
	/**
	 * 支付中
	 */
	public static final int PAY_TYPE_ZERO = 0;
	
	/**
	 * 支付成功
	 */
	public static final int PAY_TYPE_ONE = 1;
	
	/**
	 * 支付失败
	 */
	public static final int PAY_TYPE_TWO = 2;
	
	/**
	 * 支付失败已退回
	 */
	public static final int PAY_TYPE_THREE = 3;
	
	/**
	 * 不需要网络代理
	 */
	public static final String NO_PROXY = "0";
	
	/**
	 * 不需要网络代理
	 */
	public static final String NEED_PROXY = "1";
	
	/**
	 * 审核通过 微信消息模板id
	 */
	public static final int AUDIT_PASS_WECHAT_MSGID = 46;
	
	/**
	 * 审核未通过 微信消息模板id
	 */
	public static final int AUDIT_NOPASS_WECHAT_MSGID = 48;
	
	/**
	 * 审核通过 站内信消息模板id
	 */
	public static final int AUDIT_PASS_INNER_MSGID = 45;
	
	/**
	 * 审核未通过 站内信消息模板id
	 */
	public static final int AUDIT_NOPASS_INNER_MSGID = 47;
	
	/**
	 * 审核通过 短信消息模板id
	 */
	public static final int AUDIT_PASS_SMS_MSGID = 51;
	
	/**
	 * 审核未通过 短信消息模板id
	 */
	public static final int AUDIT_NOPASS_SMS_MSGID = 52;
	
}
