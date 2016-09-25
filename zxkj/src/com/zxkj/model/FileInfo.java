package com.zxkj.model;

import java.util.Date;

import lombok.Data;

@Data
public class FileInfo 
{
	private Integer id;
	
	private Integer type;
	
	private String name;
	
	private String saveName;
	
	private String saveUrl;
	
	private Date saveTime;
}
