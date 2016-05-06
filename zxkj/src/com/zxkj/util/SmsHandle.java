package com.zxkj.util;

import java.net.URL;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.Properties;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 短息发送处理类
 * @author zj
 */
public class SmsHandle {
	//日志记录器
	private static final Log logger = LogFactory.getLog(SmsHandle.class);
	//Properties
	private static Properties pro = PropertiesConfig.getInstance().getProperties("sms");
	//webservice地址
	public static final String SERVICEURL = pro.getProperty("sms.webserviceurl");
	//目标名称空间
	public static final String NAMESPACE = pro.getProperty("sms.targetnameSpace");
	public static final String SOAPACTIONURI = pro.getProperty("sms.soapActionURI");
	//短息账户
	public static final String ACCOUNT = pro.getProperty("sms.account");
	//短息密码
	public static final String PASSWORD = new DesEncrypt().decrypt(pro.getProperty("sms.password"));
	//配置网络环境标示
	public static final String NETWORK_ENVIRONMENT_MARK = pro.getProperty("sms.identify");
	//获取是否启用代理的名称
	public static final String HTTP_PROXYSET = pro.getProperty("sms.http.proxySet");
	//获取是否启用代理对应的值
	public static final String HTTP_PROXYSET_VALUE = pro.getProperty("sms.http.proxySet.value");
	//获取代理的主机名称
	public static final String HTTP_PROXYHOST = pro.getProperty("sms.http.proxyHost");
	//获取代理的主机对应的值
	public static final String HTTP_PROXYHOST_VALUE = pro.getProperty("sms.http.proxyHost.value");
	//获取代理的端口名称
	public static final String HTTP_PROXYPORT = pro.getProperty("sms.http.proxyPort");
	//获取代理的端口对应的值
	public static final String HTTP_PROXYPORT_VALUE = pro.getProperty("sms.http.proxyPort.value");
	

	/**
	 * 设置系统代理服务器地址和端口
	 */
	static {
		if(NETWORK_ENVIRONMENT_MARK.equals("1")){
			System.setProperty(SmsHandle.HTTP_PROXYSET, SmsHandle.HTTP_PROXYSET_VALUE);
			System.setProperty(SmsHandle.HTTP_PROXYHOST, SmsHandle.HTTP_PROXYHOST_VALUE);
			System.setProperty(SmsHandle.HTTP_PROXYPORT, SmsHandle.HTTP_PROXYPORT_VALUE);
		}
	}
	
	/**
	 * 短信激活
	 * @return
	 */
	public String registrationActivation(){
		String[] inputParameterNames = { "in0", "in1", "in2", "in3", "in4",
				"in5", "in6", "in7", "in8", "in9", "in10" };
		Object[] inputParameterValues = { SmsHandle.ACCOUNT, SmsHandle.PASSWORD,"北京中软国际信息技术有限公司", "中软国际", "中关村", "联系电话", "联系人", "email", "传真", "邮编", "联系手机"};
		String[] inputXmlTypes = { "string", "string", "string", "string",
				"string", "string", "string", "string", "string", "string","string" };
		return getCommonHandleAxisClient("register",inputParameterNames, inputParameterValues, inputXmlTypes).toString();
	}

	/**
	 * 短息发送
	 * @param mobile 手机号码
	 * @param content 短息内容
	 * @return 成功返回<code>String</code>
	 * @throws Exception
	 */
	public String smsSend(String mobile, String content)
			throws Exception {
		String[] inputParameterNames = { "in0", "in1", "in2", "in3", "in4",
				"in5", "in6", "in7", "in8", "in9" };
		Object[] inputParameterValues = { SmsHandle.ACCOUNT,SmsHandle.PASSWORD, mobile,
				URLEncoder.encode(content, "gbk"), "", "1", "", "1",
				"", "4" };
		String[] inputXmlTypes = { "string", "string", "string", "string",
				"string", "string", "string", "string", "string", "string" };
		return getObjectAxisCallClient("sendSMS", mobile, content,
				inputParameterNames, inputParameterValues, inputXmlTypes).toString();
	}

	/**
	 * 使用Axis Call Client动态调用WebService地址.
	 * @param webServiceMethod webService方法
	 * @param mobile 手机号码
	 * @param content 发送短息的内容
	 * @param inputNames 输入参数名称
	 * @param inputValues 输入参数值
	 * @param inputXmlTypes 输入参数XML类型
	 * @return 成功返回<code>String</code>, 失败或异常返回null.
	 */
	public String getObjectAxisCallClient(String webServiceMethod,
			String mobile, String content, String[] inputParameterNames,
			Object[] inputParameterValues, String[] inputXmlTypes) {
		String result = "";
		byte[] bt;
		boolean isSentOk = false;
		int sendTimes = 0;
		while (!isSentOk) {
			result = getCommonHandleAxisClient(webServiceMethod,
					inputParameterNames, inputParameterValues, inputXmlTypes);
			if (result != "" && result != null) {
				try {
					bt = result.getBytes("8859_1");
					String name = new String(bt, "GBK"); // 转换成GBK字符
					if (name.equals("0")) {
						isSentOk = true;
					} else {
						sendTimes++;
						if (sendTimes > 1) {
							isSentOk = true;
						} else {
							isSentOk = false;
						}
					}
				} catch (Exception e) {
					logger.info(e.getMessage());
				}
			} else {
				break;
			}
		}
		if (isSentOk) {
			if (sendTimes > 1) {
				return "-2";
			} else {
				return "0";
			}
		} else {
			return "-1";
		}
	}

	/**
	 * 公共的用来解析webservice
	 * @param webServiceMethod webService方法
	 * @param inputParameterNames 输入参数名称
	 * @param inputParameterValues 输入参数值
	 * @param inputXmlTypes 输入参数XML类型
	 * @return 成功返回<code>String</code>, 失败或异常返回null.
	 */
	public String getCommonHandleAxisClient(String webServiceMethod,
			String[] inputParameterNames, Object[] inputParameterValues,
			String[] inputXmlTypes) {
		String result = "";
		try {
			Service service = new Service();
			Call call = (Call) service.createCall();
			// 设置wsdl
			call.setTargetEndpointAddress(new URL(SmsHandle.SERVICEURL));
			// 定义参数对象
			call.setUseSOAPAction(true);
			call.setSOAPActionURI(SmsHandle.SOAPACTIONURI + webServiceMethod);
			// 设置访问的方法名
			call.setOperationName(webServiceMethod);
			if (inputParameterNames != null) {
				if (inputParameterNames.length > 0) {
					for (int i = 0; i < inputParameterNames.length; i++) {
						call.addParameter(new QName(SmsHandle.NAMESPACE,
								inputParameterNames[i]), new QName(
								SmsHandle.NAMESPACE, inputXmlTypes[i]),
								ParameterMode.IN);
					}
				}
			}
			// 设置返回类型
			call.setReturnType(XMLType.XSD_STRING);
			result = call.invoke(inputParameterValues).toString();
			String message = messageFormat(
					"使用AxisCallClient调用WebService地址｛{0}｝方法｛{1}｝成功！",
					SmsHandle.SERVICEURL, webServiceMethod);
			logger.info(message);
		} catch (Exception e) {
			e.printStackTrace();
			String message = messageFormat(
					"使用AxisCallClient调用WebService地址｛{0}｝方法｛{1}｝出现错误！",
					SmsHandle.SERVICEURL, webServiceMethod);
			logger.info(message);
			result = null;
		}
		return result;
	}

	/**
	 * 格式 消息的信息.
	 * @see java.text.MessageFormat#format(String, Object...)
	 * @param pattern 需要格式的字符串
	 * @param arguments 格式式参数
	 * @return 成功返回格式化后的内容, 否则不进行格式化操作
	 */
	public String messageFormat(String pattern, Object... arguments) {
		try {
			return MessageFormat.format(pattern, arguments);
		} catch (Exception e) {
			return pattern;
		}
	}

	public static void main(String[] args) throws Exception {
		SmsHandle smsHandle = new SmsHandle();
		smsHandle.smsSend("18706767238", "邮件测试");
	}

}