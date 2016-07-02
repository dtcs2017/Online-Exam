package com.bs.lsx.util.page;

/**
 * 分页查询对象
 *
 * @date 2014-4-4 下午5:00:40
 */
public class PageQo {
	private int pageSize;//当前页显示条数
	private int pageNum;//当前页数
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
}
