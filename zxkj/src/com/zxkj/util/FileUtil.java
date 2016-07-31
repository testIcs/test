package com.zxkj.util;

import java.io.File;

import org.apache.log4j.Logger;

public class FileUtil 
{
	private static final Logger log = Logger.getLogger(FileUtil.class);
	
	public static final void moveFile(String srcPath, String destPath)
	{
		log.info("srcPath: " + srcPath);
		log.info("destPath: " + destPath);
		String fileName = destPath + "\\" + srcPath.substring(3);
		log.info("fileName: " + fileName);
		File fileOld = new File(fileName);
		if(fileOld.exists())
		{
			log.info("fileOld exists!");
			fileOld.delete();
		}
		if(new File(srcPath).renameTo(new File(fileName)))
		{
			log.info("move file success!");
		}
		else 
		{
			log.info("move file error!");
		}
	}
}
