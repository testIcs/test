package com.zxkj.util;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.icss.lighttower.exception.BussinessException;
import com.icss.lighttowersystem.service.IMQSender;
import com.icss.lighttowersystem.service.IMessageRecord;
import com.icss.lighttowersystem.vo.MessageVO;

/**
 * 
 * MessageSendThread.java
 * @Description: 消息发送
 * @Company: chinasofti
 * @Created on 2015年12月3日 下午3:49:51
 * @author liulong
 */
public class MessageSendThread extends Thread{
	
	private static final Logger log = LoggerFactory.getLogger(MessageSendThread.class);
	
	/**
	 * 微信消息对象
	 */
	private MessageVO weChatMessage;
	
	/**
	 * 站内信对象
	 */
	private MessageVO innerMessage;
	
	/**
	 * 短信对象
	 */
	private MessageVO smsMessage;
	
	public static MessageSendThread getInstance(){
		return new MessageSendThread();
	}
	
	/**
	 * 消息发送主入口
	 */
	@Override
	public void run() {
		//发送微信消息
		sendWeChatMessage();
		
		//发送站内信消息
		sendInnerMessage();
		
		//发送手机短信
		sendSMSMessage();
	}
	
	
	//发送微信消息
	private void sendWeChatMessage(){
		try {
			//没有值不做处理
			if(null==weChatMessage|| null == weChatMessage.getMessageAccepter()){
				return;
			}
			log.debug("接收人："+weChatMessage.getMessageAccepter());
			log.debug("发送内容："+weChatMessage.getMessageContent());
			
			IMQSender mQSender = (IMQSender)SpringUtil.getApplicationContext().getBean("mQSender");
			mQSender.send("micro", weChatMessage);
			
			log.debug("微信发送成功->MessageSendThread");
		} catch (Exception e) {
			log.error("发送微信失败,原因："+e.getMessage(), e);
			throw new BussinessException("发送微信失败");
		}
	}
	
	/**
	 * 发送站内信消息
	 */
	private void sendInnerMessage(){
		//没有值不做处理
		if(innerMessage==null||innerMessage.getMessageAccepter()==null){
			return;
		}
		IMessageRecord messageManager = (IMessageRecord)SpringUtil.getApplicationContext().getBean("messageManager");
		List<MessageVO> mlist = new ArrayList<MessageVO>();
		mlist.add(innerMessage);
		messageManager.addMessageRecordList(mlist);
	}
	
	/**
	 * 发送手机短信
	 */
	private void sendSMSMessage(){
		//没有值不做处理
		if(smsMessage==null||smsMessage.getMessageAccepter()==null){
			return;
		}
		SmsHandle smsHandle = null;
		String result = null;
		try {
			smsHandle = new SmsHandle();
			result = smsHandle.smsSend(smsMessage.getMessageAccepter(),smsMessage.getMessageContent());
		} catch (Exception e) {
			throw new BussinessException("发送短信失败");
		}
		if (result.equals("0")) {
			log.info("发送内容:[" + "]到手机号码[" + smsMessage.getMessageAccepter() + "]上!");
		}
	}
	
	/**
	 * 微信对象set方法
	 * @param weChatMessage
	 */
	public void setWeChat(MessageVO weChatMessage) {
		this.weChatMessage = weChatMessage;
	}
	
	/**
	 * 站内信对象set方法
	 * @param innerMessage
	 */
	public void setInnerMessage(MessageVO innerMessage) {
		this.innerMessage = innerMessage;
	}
	
	/**
	 * 短信对象set方法
	 * @param smsMessage
	 */
	public void setSmsMessage(MessageVO smsMessage) {
		this.smsMessage = smsMessage;
	}

	
}
