package com.zxkj.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icss.lighttowersystem.model.UserBase;
import com.icss.lighttowersystem.util.SmsHandle;
import com.icss.lighttowersystem.vo.MessageVO;


@Scope("prototype")
@Controller
@RequestMapping("/zxkj/messgae")
public class SendMessageController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6421970907012287749L;
	
	private static final Log logger = LogFactory.getLog(SendMessageController.class);
	
	@Setter
	@Getter
	private MessageVO mSendInfo = new MessageVO();
	
	/**
	 * 发送短信消息
	 */
	@RequestMapping(value="sendmessage", method = RequestMethod.POST)
	private @ResponseBody void sendSmsMessage(){
		List<MessageVO> mlist = new ArrayList<MessageVO>();
//		String[] str = userId.split(",");
//		String[] strRepeat = Duplicate(str);
//		String[] deId = deleteId.split(",");
//		String[] deIdRepeat = Duplicate(deId);
//		String[] result_union = null;
//		if(strRepeat.length <=1){
//			result_union = strRepeat;
//		}else{
//			result_union = minus(strRepeat, deIdRepeat); 
//		} 
			MessageVO mSendInfoNew = new MessageVO();
//				UserBase user = userBaseManager.findUserByUserIdInterface(Integer.parseInt(st));
				mSendInfoNew.setMessageAccepter("aaa");
				mSendInfoNew.setUserId(11);
				mSendInfoNew.setMessageContent(mSendInfo.getMessageContent());
				mSendInfoNew.setMessageType(1);
				mSendInfoNew.setMessageAuto(0);
				mSendInfoNew.setMessageKind(2);
				mSendInfoNew.setMessageState(0);
				mSendInfoNew.setMessageStyle(0);
				//消息的发送时间
				mSendInfoNew.setMessageTime(new java.sql.Date(System.currentTimeMillis()));
				mSendInfoNew.setMessageTitle(mSendInfo.getMessageTitle());
					SmsHandle smsHandle = new SmsHandle();
					String result = null;
					try {
						result = smsHandle.smsSend("13152173881", mSendInfo.getMessageContent());
					} catch (Exception e) {
						e.printStackTrace();
					}
					if(result.equals("0") || result.equals("-2")){
						mSendInfoNew.setMessageResult(0);
						logger.info("发送内容:["+ mSendInfo.getMessageContent() + "]到手机号码[" + "13152173881" + "]上!");
					}else if(result.equals("-1")){
						mSendInfoNew.setMessageResult(1);
					}else{
						mSendInfoNew.setMessageResult(2);
					}
					
					mlist.add(mSendInfoNew);
//		messageManager.addMessageRecordList(mlist);
	}
	

}
