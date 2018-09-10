package com.wangyang.model;

import java.util.List;

public class Pager<T> {
	private int totalRecord;
	private int totoalPage;
	private int currentPage;
	private int pageSize;
	private List<T> list;
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getTotoalPage() {
		return totoalPage;
	}
	public void setTotoalPage(int totoalPage) {
		this.totoalPage = totoalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	
}
