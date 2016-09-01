package com.etaoguan.wea.client.mobile.vo;

import java.util.List;

import com.etaoguan.wea.common.DataSet;

public class MPage<T> {
	
	private MPagingNavInfo mpagingNavInfo;

	private List<T> dataList;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public MPage(MPagingNavInfo mpageNavInfo,List dataList){
		this.dataList = dataList;
		this.mpagingNavInfo = mpageNavInfo;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public MPage(MPagingRequest mpagingRequest,DataSet dataSet){
		this.mpagingNavInfo = calcPageNavInfo(mpagingRequest,dataSet);
		this.dataList = dataSet.getDataList();

	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

	public MPagingNavInfo getMpagingNavInfo() {
		return mpagingNavInfo;
	}

	public void setMpagingNavInfo(MPagingNavInfo mpagingNavInfo) {
		this.mpagingNavInfo = mpagingNavInfo;
	}
	
	@SuppressWarnings("rawtypes")
	private MPagingNavInfo calcPageNavInfo(MPagingRequest mpagingRequest,DataSet dataSet){
		
		int totalRecNum=dataSet.getTotalRecNum();
		int currentPage=mpagingRequest.getCurrentPage();
		int perPageUnitNum=mpagingRequest.getPerPageUnitNum();
		
		if(perPageUnitNum==0){
			return null;
		}
		int totalPages = totalRecNum/perPageUnitNum;
		int lastPageNum = totalRecNum%perPageUnitNum;
		if(lastPageNum>0){
			totalPages = totalPages+1;
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

		MPagingNavInfo mpagingNavInfo = new MPagingNavInfo();
		mpagingNavInfo.setTotalRecNum(totalRecNum);
		mpagingNavInfo.setTotalPages(totalPages);
		mpagingNavInfo.setCurrentPage(currentPage);
		mpagingNavInfo.setHavePrePage(havePrePage);
		mpagingNavInfo.setHaveNextPage(haveNextPage);

		return mpagingNavInfo;
	}
}
