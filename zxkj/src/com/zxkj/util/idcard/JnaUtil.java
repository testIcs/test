package com.zxkj.util.idcard;

import java.io.UnsupportedEncodingException;

import org.apache.log4j.Logger;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.zxkj.util.FileUtil;

public class JnaUtil
{
	private static final Logger log = Logger.getLogger(JnaUtil.class);
	
	private static int USB_NO_MIN = 1001;
	
	private static int USB_NO_MAX = 1016;
	
	private static String splitIdCardInfo(Pointer pointer, String photoPath)
	{
		String idCardInfoNew = "";
		String idCardInfoOld = null;
		try {
			idCardInfoOld = new String(pointer.getString(0).getBytes("GB2312"), "GBK");
			System.out.println(idCardInfoOld+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			log.info("idCardInfoOld: " + idCardInfoOld);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String[] strNewArrOld = idCardInfoOld.split("-");
		String name = strNewArrOld[0];
		idCardInfoNew += name;
		idCardInfoNew += "-";
		String sex = strNewArrOld[1].substring(strNewArrOld[1].length()-1);
		idCardInfoNew += sex;
		idCardInfoNew += "-";
		String nation = strNewArrOld[2].substring(strNewArrOld[2].length()-1);
		idCardInfoNew += nation;
		idCardInfoNew += "-";
		String born = strNewArrOld[3].substring(strNewArrOld[3].length()-11);
		idCardInfoNew += born;
		idCardInfoNew += "-";
		String address = strNewArrOld[4].substring(24);
		idCardInfoNew += address;
		idCardInfoNew += "-";
		String idCard = strNewArrOld[5].substring(24);
		idCardInfoNew += idCard;
		idCardInfoNew += "-";
		String fileName = strNewArrOld[6].substring(24);
		
		// 将生成的文件移动到项目路径下
		FileUtil.moveFile(fileName, photoPath);
		
		idCardInfoNew += fileName;
		log.info("idCardInfoNew: " + idCardInfoNew);
		return idCardInfoNew;
	}
	
	private static int findReader()
	{
		return SynLibrary.INSTANCE.Syn_FindReader();
	}
	
	private static int openPort(int portNo)
	{
		return SynLibrary.INSTANCE.Syn_OpenPort(portNo);
	}
	
	private static void readIdCard(int portNo, Pointer pointer)
	{
		JdjLibrary.INSTANCE.readIdCard(portNo, pointer);
	}
	
	private static int closePort(int portNo)
	{
		return SynLibrary.INSTANCE.Syn_ClosePort(portNo);
	}
	
	public static String readIdCardInfo(String photoPath)
	{
		System.setProperty("jna.encoding", "GB2312");
		int portNo = findReader();
		
		if(USB_NO_MIN <= portNo || portNo <= USB_NO_MAX)
		{
			int openPortFlag = openPort(portNo);
			if(0 == openPortFlag)
			{
				Pointer pointer = new Memory(1000); 
				readIdCard(portNo, pointer);
				String idCardInfo = splitIdCardInfo(pointer, photoPath);
				closePort(portNo);
				return idCardInfo;
			}
			else 
			{
				log.info("USB接口打开失败!");
				return "";
			}
		}
		else 
		{
			log.info("USB接口不合法!");
			return "";
		}
	}
}
