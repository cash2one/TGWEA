package com.etaoguan.wea.client.web.vo;

import com.etaoguan.wea.vo.Admin;

public class WAdmin {
	
	private Admin admin;
	
	private int[] groupIds;

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public int[] getGroupIds() {
		return groupIds;
	}

	public void setGroupIds(int[] groupIds) {
		this.groupIds = groupIds;
	}

}
