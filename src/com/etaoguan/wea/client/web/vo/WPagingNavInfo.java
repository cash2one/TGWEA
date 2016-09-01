package com.etaoguan.wea.client.web.vo;

import com.etaoguan.wea.client.vo.PageNavInfo;

public class WPagingNavInfo extends PageNavInfo{

	
	private int showMidPageNum = 8;
	
	private int midPageIndex;

	public int getShowMidPageNum() {
		return showMidPageNum;
	}

	public void setShowMidPageNum(int showMidPageNum) {
		this.showMidPageNum = showMidPageNum;
	}

	public int getMidPageIndex() {
		return midPageIndex;
	}

	public void setMidPageIndex(int midPageIndex) {
		this.midPageIndex = midPageIndex;
	}
	
}
