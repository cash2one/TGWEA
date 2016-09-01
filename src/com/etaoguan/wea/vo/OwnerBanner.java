package com.etaoguan.wea.vo;

public class OwnerBanner extends BaseVo{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long bannerId;
	private String ownerNum;
	private String imgUrl;
	private int linkType;
	private String linkContent;
	private String linkRemark;
	private int sequence;
	private String remark;
	
	public String getOwnerNum() {
		return ownerNum;
	}
	public void setOwnerNum(String ownerNum) {
		this.ownerNum = ownerNum;
	}
	public int getLinkType() {
		return linkType;
	}
	public void setLinkType(int linkType) {
		this.linkType = linkType;
	}
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	public long getBannerId() {
		return bannerId;
	}
	public void setBannerId(long bannerId) {
		this.bannerId = bannerId;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getLinkContent() {
		return linkContent;
	}
	public void setLinkContent(String linkContent) {
		this.linkContent = linkContent;
	}
	public String getLinkRemark() {
		return linkRemark;
	}
	public void setLinkRemark(String linkRemark) {
		this.linkRemark = linkRemark;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

}
