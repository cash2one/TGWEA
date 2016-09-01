package com.etaoguan.wea.client.web.vo;

import java.util.List;

import com.etaoguan.wea.common.DataSet;

public class WPage<T> {
	
	private WPagingNavInfo wpagingNavInfo;

	private List<T> dataList;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public WPage(WPagingNavInfo wpageNavInfo,List dataList){
		this.dataList = dataList;
		this.wpagingNavInfo = wpageNavInfo;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public WPage(WPagingRequest wpagingRequest,DataSet dataSet){
		this.wpagingNavInfo = calcPageNavInfo(wpagingRequest,dataSet);
		this.dataList = dataSet.getDataList();

	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

	
	@SuppressWarnings("rawtypes")
	private WPagingNavInfo calcPageNavInfo(WPagingRequest wpagingRequest,DataSet dataSet){
		
		int totalRecNum=dataSet.getTotalRecNum();
		int currentPage=wpagingRequest.getCurrentPage();
		int perPageUnitNum=wpagingRequest.getPerPageUnitNum();
		int showMidPageNum=wpagingRequest.getShowMidPageNum();
		
		if(perPageUnitNum==0||showMidPageNum==0){
			return null;
		}
		int totalPages = totalRecNum/perPageUnitNum;
		int lastPageNum = totalRecNum%perPageUnitNum;
		if(lastPageNum>0){
			totalPages = totalPages+1;
		}
		
		int midPageIndex = (currentPage/showMidPageNum)*showMidPageNum;
		int currentMidPageIndex = currentPage%showMidPageNum;
		if(currentMidPageIndex==0&&midPageIndex>0){
			midPageIndex = midPageIndex-showMidPageNum+1;
		}
		else{
			midPageIndex = midPageIndex+1;
		}
		
		boolean havePrePage = false,haveNextPage = false;
		if(totalRecNum==0){
			havePrePage = false;
			haveNextPage = false;
		}
		else{
			if(currentPage>1){
				havePrePage = true;
			}
			if(currentPage<totalPages){
				haveNextPage = true;
			}
		}
		
		if(totalPages<(midPageIndex+showMidPageNum-1)){
			showMidPageNum = totalPages-midPageIndex+1;
		}

		WPagingNavInfo wpagingNavInfo = new WPagingNavInfo();
		wpagingNavInfo.setTotalRecNum(totalRecNum);
		wpagingNavInfo.setTotalPages(totalPages);
		wpagingNavInfo.setCurrentPage(currentPage);
		wpagingNavInfo.setHavePrePage(havePrePage);
		wpagingNavInfo.setHaveNextPage(haveNextPage);
		wpagingNavInfo.setShowMidPageNum(showMidPageNum);
		wpagingNavInfo.setMidPageIndex(midPageIndex);;

		return wpagingNavInfo;
	}

	public WPagingNavInfo getWpagingNavInfo() {
		return wpagingNavInfo;
	}

	public void setWpagingNavInfo(WPagingNavInfo wpagingNavInfo) {
		this.wpagingNavInfo = wpagingNavInfo;
	}
}
