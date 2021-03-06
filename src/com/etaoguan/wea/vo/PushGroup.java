package com.etaoguan.wea.vo;

import java.util.List;

public class PushGroup  extends BaseVo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String groupNum;
	
	private String ownerNum;
	
	private String groupName;
	
	private String remark;

	private List<PushGroupCustRef> pushGroupCustRefs;


	public String getOwnerNum() {
		return ownerNum;
	}

	public void setOwnerNum(String ownerNum) {
		this.ownerNum = ownerNum;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<PushGroupCustRef> getPushGroupCustRefs() {
		return pushGroupCustRefs;
	}

	public void setPushGroupCustRefs(List<PushGroupCustRef> pushGroupCustRefs) {
		this.pushGroupCustRefs = pushGroupCustRefs;
	}

	public String getGroupNum() {
		return groupNum;
	}

	public void setGroupNum(String groupNum) {
		this.groupNum = groupNum;
	}
}
