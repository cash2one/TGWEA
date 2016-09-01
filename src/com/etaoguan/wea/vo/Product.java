package com.etaoguan.wea.vo;

import java.util.List;

import com.etaoguan.wea.common.WeaDataCache;

public class Product extends BaseVo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String prodNum;
	private String prodName;
	private String ownerNum;
	private String prodCatId;
	private int posSeq;
	private int topFlag;
	private int newFlag;
	private int hotFlag;
	private int showFlag;
	@SuppressWarnings("unused")
	private String showName;
	private double stdPrice;
	private int dispStockBalance;
	private String unit;
	private String remark;
	private String firstProdImg;
	private String externalSysCode;
	private String featureName;
	/**
	 * 是否公开  默认为0：公开，1：不公开
	 */
	private String isPublic;
	private String[] productNums;
	private List<ProdImg> prodImgs;
	private List<ProdFeature> prodFeatures;
	private List<ProdDiffer> prodDiffers;
	private List<ProdExternal> prodExternals;
	
	public String[] getProductNums() {
		return productNums;
	}
	public void setProductNums(String[] productNums) {
		this.productNums = productNums;
	}
	public String getIsPublic() {
		return isPublic;
	}
	public void setIsPublic(String isPublic) {
		this.isPublic = isPublic;
	}
	public String getFeatureName() {
		return featureName;
	}
	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}
	public String getProdNum() {
		return prodNum;
	}
	public void setProdNum(String prodNum) {
		this.prodNum = prodNum;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getOwnerNum() {
		return ownerNum;
	}
	public void setOwnerNum(String ownerNum) {
		this.ownerNum = ownerNum;
	}
	public String getProdCatId() {
		return prodCatId;
	}
	public void setProdCatId(String prodCatId) {
		this.prodCatId = prodCatId;
	}
	public int getPosSeq() {
		return posSeq;
	}
	public void setPosSeq(int posSeq) {
		this.posSeq = posSeq;
	}
	public int getTopFlag() {
		return topFlag;
	}
	public void setTopFlag(int topFlag) {
		this.topFlag = topFlag;
	}
	public int getNewFlag() {
		return newFlag;
	}
	public void setNewFlag(int newFlag) {
		this.newFlag = newFlag;
	}
	public int getHotFlag() {
		return hotFlag;
	}
	public void setHotFlag(int hotFlag) {
		this.hotFlag = hotFlag;
	}
	public int getShowFlag() {
		return showFlag;
	}
	public void setShowFlag(int showFlag) {
		this.showFlag = showFlag;
	}
	public int getDispStockBalance() {
		return dispStockBalance;
	}
	public void setDispStockBalance(int dispStockBalance) {
		this.dispStockBalance = dispStockBalance;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public List<ProdImg> getProdImgs() {
		return prodImgs;
	}
	public void setProdImgs(List<ProdImg> prodImgs) {
		this.prodImgs = prodImgs;
	}
	public List<ProdFeature> getProdFeatures() {
		return prodFeatures;
	}
	public void setProdFeatures(List<ProdFeature> prodFeatures) {
		this.prodFeatures = prodFeatures;
	}
	
	public List<ProdDiffer> getProdDiffers() {
		return prodDiffers;
	}
	public void setProdDiffers(List<ProdDiffer> prodDiffers) {
		this.prodDiffers = prodDiffers;
	}
	public double getStdPrice() {
		return stdPrice;
	}
	public void setStdPrice(double stdPrice) {
		this.stdPrice = stdPrice;
	}
	public String getFirstProdImg() {
		return firstProdImg;
	}
	public void setFirstProdImg(String firstProdImg) {
		this.firstProdImg = firstProdImg;
	}
	public List<ProdExternal> getProdExternals() {
		return prodExternals;
	}
	public void setProdExternals(List<ProdExternal> prodExternals) {
		this.prodExternals = prodExternals;
	}
	public String getExternalSysCode() {
		return externalSysCode;
	}
	public void setExternalSysCode(String externalSysCode) {
		this.externalSysCode = externalSysCode;
	}
	public String getShowName() {
		return WeaDataCache.getCache().getProdShowFlagCodeNameMap().get(String.valueOf(this.showFlag));
	}
	public void setShowName(String showName) {
		this.showName = showName;
	}

	
	
}
