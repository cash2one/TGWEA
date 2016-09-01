package com.etaoguan.wea.client.web.vo;

import com.etaoguan.wea.client.vo.PagingRequest;
public class WPagingRequest extends PagingRequest{
	
	private int showMidPageNum = 8;

	public int getShowMidPageNum() {
		return showMidPageNum;
	}

	public void setShowMidPageNum(int showMidPageNum) {
		this.showMidPageNum = showMidPageNum;
	}
	


}
