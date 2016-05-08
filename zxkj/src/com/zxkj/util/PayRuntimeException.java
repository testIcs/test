package com.zxkj.util;

import lombok.Getter;
import lombok.Setter;

/**
 * 自定义支付异常
 * @author zhengjiaoguo love yangqianqian
 * @date 2015年7月6日 下午4:34:17
 */
@Getter
@Setter
public class PayRuntimeException extends RuntimeException {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7386893166979265536L;

	private String exceptionMsg;
	
	private String originalExceptionMsg;
	
	private String exceptionStackPath;
}
