package com.zxkj.util;

import java.io.File;

import org.apache.log4j.Logger;

public class FileUtil 
{
	private static final Logger log = Logger.getLogger(FileUtil.class);
	
	/**
	 * 移动文件 
	 */
	public static final void moveFile(String srcPath, String destPath)
	{
		log.info("srcPath: " + srcPath);
		log.info("destPath: " + destPath);
		String fileName = destPath + "\\" + srcPath.substring(srcPath.length() - 6);
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
	
	/**
	 * 创建一个指定文件夹名称的文件夹 
	 */
	public static final boolean makeFolderByPath(final String filePath)
	{
		return new File(filePath).mkdir();
	}
	
	public static final boolean judgeFileExist(final String folderPath)
	{
		File file = new File(folderPath);
		if(file.isDirectory())
		{
			if(0 < file.list().length)
			{
				return true;
			}
			else 
			{
				return false;
			}
		}
		else 
		{
			return false;
		}
	}
}
