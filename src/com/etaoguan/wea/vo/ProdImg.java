package com.etaoguan.wea.vo;

public class ProdImg  extends BaseVo{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String prodNum;
	private String imgUrl;
	private int imgSeq;
	private String thumbUrl;
	private String remark;
	public String getProdNum() {
		return prodNum;
	}
	public void setProdNum(String prodNum) {
		this.prodNum = prodNum;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public int getImgSeq() {
		return imgSeq;
	}
	public void setImgSeq(int imgSeq) {
		this.imgSeq = imgSeq;
	}
	public String getThumbUrl() {
		return thumbUrl;
	}
	public void setThumbUrl(String thumbUrl) {
		this.thumbUrl = thumbUrl;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

}
