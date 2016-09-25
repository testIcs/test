package com.zxkj.vo;

import java.io.Serializable;

import lombok.Data;
@Data
public class UserLoanVO implements Serializable
{
	private Integer id;
	
	private Integer userId;
	
	private Integer termId;
	
	private Integer typeId;
	
	private Integer ratioId;
	
}
