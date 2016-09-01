package com.etaoguan.wea.client.web.vo;

import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.etaoguan.wea.client.vo.WeaResponse;

public class WWeaResponse extends WeaResponse{

	@SuppressWarnings("rawtypes")
	private List rows;
	
	private int total;
	
	private Object searchParams;

	@SuppressWarnings("rawtypes")
	@JSON(name="Rows")
	public List getRows() {
		return rows;
	}

	@SuppressWarnings("rawtypes")
	public void setRows(List rows) {
		this.rows = rows;
	}

	@JSON(name="Total")
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Object getSearchParams() {
		return searchParams;
	}

	public void setSearchParams(Object searchParams) {
		this.searchParams = searchParams;
	}


	
}
