package com.zxkj.vo;

import java.util.Date;

import lombok.Data;

@Data
public class UserFingerPrintVO 
{
	private Integer userId;
	
	private Integer fingerPrintId;
	
	private Date addTime;
}
