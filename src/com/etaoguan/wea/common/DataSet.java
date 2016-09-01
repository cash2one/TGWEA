package com.etaoguan.wea.common;

import java.util.ArrayList;
import java.util.List;

public class DataSet<T> {
	
	private int totalRecNum;
	
	private int totalPage;
	
	private List<T> dataList = new ArrayList<T>();

	public int getTotalRecNum() {
		return totalRecNum;
	}

	public void setTotalRecNum(int totalRecNum) {
		this.totalRecNum = totalRecNum;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
}
