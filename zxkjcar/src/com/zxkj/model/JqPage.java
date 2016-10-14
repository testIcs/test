package com.zxkj.model;

import java.io.Serializable;


public class JqPage implements Serializable{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5700284200239790002L;
	
	/**
	 * 每页需要显示的记录条数
	 */
	private Integer rows = 10;
	
	/**
	 * 第几页
	 */
	private Integer page = 1;
	
	/**
	 * 一共有多少页
	 */
	private Integer totalPage = 0;
	
	/**
	 * 一共有多少行记录
	 */
	private Integer record = 0;
	
	private String sord = "";
	private String nd = "";
	private String sidx = "";
	
	private String search = "";

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getRecord() {
		return record;
	}

	public void setRecord(Integer record) {
		this.record = record;
	}

	public String getSord() {
		return sord;
	}

	public void setSord(String sord) {
		this.sord = sord;
	}

	public String getNd() {
		return nd;
	}

	public void setNd(String nd) {
		this.nd = nd;
	}

	public String getSidx() {
		return sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
	
	public void calcTotalPage(){
		this.setTotalPage(record % rows ==0? record / rows : record / rows+1);
	}
}