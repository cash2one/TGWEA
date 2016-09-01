package com.etaoguan.wea.client.vo;

import com.etaoguan.wea.common.OffsetRequest;

public class PagingRequest {

	private int perPageUnitNum = 20;
	
	private int currentPage = 1;
	

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPerPageUnitNum() {
		return perPageUnitNum;
	}

	public void setPerPageUnitNum(int perPageUnitNum) {
		this.perPageUnitNum = perPageUnitNum;
	}
	
	public OffsetRequest format2OffsetRequest(){
		int perPageUnitNum = getPerPageUnitNum();
		int currentPage = getCurrentPage();
		OffsetRequest offsetRequest = new OffsetRequest();
		offsetRequest.setPerUnitNum(getPerPageUnitNum());
		offsetRequest.setOffset(perPageUnitNum*(currentPage-1));
		return offsetRequest;
	}

}
