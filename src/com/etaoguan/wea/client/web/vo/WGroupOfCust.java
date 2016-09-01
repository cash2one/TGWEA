package com.etaoguan.wea.client.web.vo;

import com.etaoguan.wea.vo.GroupOfCust;

public class WGroupOfCust {
	
	private GroupOfCust groupOfCust;

	private String[] custNums;


	public GroupOfCust getGroupOfCust() {
		return groupOfCust;
	}

	public void setGroupOfCust(GroupOfCust groupOfCust) {
		this.groupOfCust = groupOfCust;
	}

	public String[] getCustNums() {
		return custNums;
	}

	public void setCustNums(String[] custNums) {
		this.custNums = custNums;
	}

}
