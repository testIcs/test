package com.zxkj.util;

/**
 * ��ҳ��ѯ������
 * 
 * PageUtil.java
 * 
 * @Description: <br>
 * <br>
 * @Company: chinasofti
 * @Created on 2016��9��18�� ����4:41:11
 * @author liulong
 * @param <T>
 */
public class PagerUtil
{
    /**
     * ÿҳ��ʾ����
     */
    private Integer pageSize = 20;

    /**
     * ҳ��
     */
    private Integer pageNo;

    /**
     * ����
     */
    private Integer totalRecords;

    /**
     * ��ҳ��
     */
    private Integer totalPage;

    public Integer getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(Integer pageSize)
    {
        this.pageSize = pageSize;
    }

    public Integer getPageNo()
    {
        return pageNo;
    }

    public void setPageNo(Integer pageNo)
    {
        this.pageNo = pageNo;
    }

    public Integer getTotalRecords()
    {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords)
    {
        this.totalRecords = totalRecords;
    }

    public Integer getTotalPage()
    {
        totalPage = this.totalRecords % this.pageSize == 0 ? this.totalRecords / this.pageSize : this.totalRecords
                / this.pageSize + 1;
        return totalPage;
    }

    public void setTotalPage(Integer totalPage)
    {
        this.totalPage = totalPage;
    }

}
